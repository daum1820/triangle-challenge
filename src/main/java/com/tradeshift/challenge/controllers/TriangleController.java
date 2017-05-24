package com.tradeshift.challenge.controllers;

import com.tradeshift.challenge.models.Response;
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

    @RequestMapping(value = "/triangle", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Response> getTriangleType(@RequestBody(required = false) Triangle triangle) {
        ResponseEntity responseEntity;
        Response response = new Response();

        try{
            Triangle.TriangleType polygonType = triangleService.getPolygonType(triangle);
            response.setMessage("This triangle is : " + polygonType.name());
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            response.setMessage(e.getMessage());
            responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
