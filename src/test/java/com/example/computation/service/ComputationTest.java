package com.example.computation.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputationTest {
    @Test
    public void computeTestOne(){
        ComputationService computation = new ComputationService();
        double result = computation.compute(1.0, 3.0, 5.0);
        Assertions.assertEquals(9.0, result);
    }

    @Test
    public void computeTestTwo(){
        ComputationService computation = new ComputationService();
        double result = computation.compute(3.0, 3.0, 5.0);
        Assertions.assertEquals(11.0, result);
    }
}
