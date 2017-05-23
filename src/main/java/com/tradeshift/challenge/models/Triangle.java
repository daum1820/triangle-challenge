package com.tradeshift.challenge.models;

import java.util.ArrayList;

public class Triangle extends Polygon<Integer>{

    public enum TriangleType {
        EQUILATERAL, ISOSCELES, SCALENE
    }

    public Triangle(){

    }

    public Triangle(Integer sideOne, Integer sideTwo, Integer sideThree){
        this.sides = new ArrayList();
        sides.add(new PolygonSide<>(sideOne));
        sides.add(new PolygonSide<>(sideTwo));
        sides.add(new PolygonSide<>(sideThree));
    }
}
