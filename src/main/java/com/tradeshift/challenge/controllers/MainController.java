package com.tradeshift.challenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "api/health", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getHealth() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}