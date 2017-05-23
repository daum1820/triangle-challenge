package com.tradeshift.challenge.controllers;

import com.tradeshift.challenge.models.Triangle;
import com.tradeshift.challenge.services.TriangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TriangleController {

    private TriangleService triangleService;

    @Autowired
    public TriangleController(TriangleService triangleService){
        this.triangleService = triangleService;
    }

    @RequestMapping(value = "/triangle", method = RequestMethod.POST)
    public ResponseEntity<String> getTriangleType(@RequestBody(required = false) Triangle triangle) {
        ResponseEntity responseEntity;

        try{
            Triangle.TriangleType polygonType = triangleService.getPolygonType(triangle);
            responseEntity = new ResponseEntity<>(polygonType.name(), HttpStatus.OK);
        } catch (Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
