package com.example.computation.controller;

import com.example.computation.service.ComputationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("compute")
public class ComputationController {
    ComputationService computationService;

    @Autowired
    public ComputationController(ComputationService computationService) {
        this.computationService = computationService;
    }

    @GetMapping("/sum")
    public double sum(@RequestParam("a") double a, @RequestParam("b")double b){
        return computationService.sum(a,b);
    }
}
