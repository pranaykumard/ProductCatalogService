package com.example.productcatalogservice;

import org.junit.jupiter.api.Test;
import org.springframework.cache.Cache;

import static org.junit.jupiter.api.Assertions.assertThrows;


class CalculatorTest {

    @Test
    public void testAdd_On2Integers_RunSuccessfully() {
        //arrange
        Calculator calculator = new Calculator();
        //Act
        int res = calculator.add(2, 2);
        //assert
        assert(res == 4);
    }

    @Test
    public void testDivide_ByZero_ResultsInArithmeticException(){
        //arrange
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class,()->calculator.divide(10, 0));
    }

}