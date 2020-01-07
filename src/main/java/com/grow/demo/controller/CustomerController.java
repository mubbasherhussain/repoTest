package com.grow.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grow.demo.model.CustomerInput;
import com.grow.demo.service.CustomerService;

@RestController
public class CustomerController {
	@GetMapping(path="multiplication")
	public double getMultiplication(@RequestBody CustomerInput ci) {
		double k = CustomerService.getMultiplication(ci.getInput1(), ci.getInput2());
		return k;
	}
	@GetMapping(path="subtraction")
	public double getSubtraction(@RequestBody CustomerInput ci) {
		double k = CustomerService.getSubtraction(ci.getInput1(), ci.getInput2());
		return k;
	}
	@GetMapping(path="equal")
	public boolean checkEqual(@RequestBody CustomerInput ci) {
		boolean k = CustomerService.checkEqual(ci.getInput1(), ci.getInput2());
		return k;
	}	 
}
