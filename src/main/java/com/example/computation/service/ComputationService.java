package com.example.computation.service;

import org.springframework.stereotype.Service;

@Service
public class ComputationService {

    public double sum(double a, double b){
        return a + b;
    }

    static final double PI = 3.142;
    public double compute(double... nums){

        double result =0.0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        if(result > 10){
            System.out.println("Result is greater than 10");
        }
        return result;
    }
}
