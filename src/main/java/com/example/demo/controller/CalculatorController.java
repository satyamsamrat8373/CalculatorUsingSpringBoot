package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.CalculatorService;

@Controller
@RequestMapping("/api")
public class CalculatorController {
				
		
				@Autowired
				CalculatorService cs;
				
				@RequestMapping("/")
				public String home() {
					return "home";
				}
				
				@RequestMapping("/calculate")
				public String Calculator(@RequestParam("num1") double num1, @RequestParam("num2") double num2,@RequestParam("operation") String operation,Model model) {
						double result = 0;
						switch(operation) {
						case "add":
									result = cs.add(num1,num2);
										break;
						
						case "sub":
									result = cs.subtract(num1,num2);
										break;
										
						case "mul":
									result = cs.multiply(num1,num2);
										break;
										
						case "div":
									if (num2 != 0) {
									result = cs.divide(num1,num2);
									} else {
										result = 0;
									}
										break;
										
						default:
									model.addAttribute("error","Invalid Operation");
									return "result";
									
						}
									model.addAttribute("num1", num1);
									model.addAttribute("num2", num2); 
									model.addAttribute("operation", operation);
									model.addAttribute("result", result);
									return "result";
				
				}
}
