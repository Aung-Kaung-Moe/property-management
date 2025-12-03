package com.mycompanyapp.property_management.controller;

public class CalculatorMain {
    
    public static void main(String[] args) {
        CalculatorController cc = new CalculatorController();
        Double result = cc.add(5.0, 3.0);
        System.out.println("The result of addition is: " + result);
    }
}
