package com.mycompanyapp.property_management.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mycompanyapp.property_management.dto.CaluculatorDTO;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping("/add")
    public Double add(@RequestParam("num1") Double num1,@RequestParam("num2") Double num2) {
        return num1 + num2;
    }

    @GetMapping("/subtract/{num1}/{num2}")
    public Double subtract(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2) {
        Double result = null;
        if (num1 != null && num2 != null) {
            if (num1 >= num2) {
                result = num1 - num2;
            } else {
                result = num2 - num1;
            }
        }
        return result;
    }

    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestBody CaluculatorDTO calculatorDTO) {
        Double result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4();
        return new ResponseEntity<Double>(result, HttpStatus.CREATED);
    }
}
