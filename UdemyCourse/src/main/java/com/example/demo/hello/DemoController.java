package com.example.demo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	@RequestMapping("hello")
	@ResponseBody
	public String sayHello() {
		return "hello, how are you today?";
	}
	
	@RequestMapping("helloJsp")
	
	public String sayHelloJsp() {
		return "HelloJsp";
	}
}
