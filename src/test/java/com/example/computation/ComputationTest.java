package com.example.computation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputationTest {
    @Test
    public void computeTestOne(){
        Computation computation = new Computation();
        double result = computation.compute(1.0, 3.0, 5.0);
        Assertions.assertEquals(9.0, result);
    }

    @Test
    public void computeTestTwo(){
        Computation computation = new Computation();
        double result = computation.compute(3.0, 3.0, 5.0);
        Assertions.assertEquals(11.0, result);
    }
}
