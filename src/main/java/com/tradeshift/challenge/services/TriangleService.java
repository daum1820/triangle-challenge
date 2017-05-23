package com.tradeshift.challenge.services;

import com.tradeshift.challenge.models.Triangle;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service("triangleService")
public class TriangleService implements PolygonService<Triangle.TriangleType, Triangle>{

    private void verifyTriangleSides(List<Integer> sides){

        if(sides == null || sides.size() != 3){
            throw new IllegalArgumentException("Triangle must have 3 sides");
        }

        for (Integer side : sides) {
            if(side == null || side <= 0){
                throw new IllegalArgumentException("Triangle's side must be bigger than 0");
            }
        }

        if(sides.get(0) > sides.get(1) + sides.get(2)
           || sides.get(1) > sides.get(0) + sides.get(2)
           || sides.get(2) > sides.get(0) + sides.get(1)){
            throw new IllegalArgumentException("This is a triangle inequality");
        }

    }

    @Override
    public Triangle.TriangleType getPolygonType(Triangle triangle) {
        Assert.notNull(triangle, "Triangle must not be null");
        Assert.notEmpty(triangle.getSides(), "Triangle's sides must not be null");

        //Get only side's length (Java 8)
        List<Integer> sides = triangle.getSides().stream().map(side -> side.getSide()).collect(Collectors.toList());

        verifyTriangleSides(sides);

        Triangle.TriangleType triangleType = Triangle.TriangleType.SCALENE;

        if(sides.get(0).equals(sides.get(1))
           && sides.get(0).equals(sides.get(2))){

            triangleType = Triangle.TriangleType.EQUILATERAL;

        } else if(sides.get(0).equals(sides.get(1))
           || sides.get(1).equals(sides.get(2))
           || sides.get(2).equals(sides.get(0))){
            triangleType = Triangle.TriangleType.ISOSCELES;
        }

        return triangleType;
    }
}
