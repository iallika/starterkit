package com.mkyong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld(ModelMap model) {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);

//		model.addAttribute("message", "Spring 3 MVC Hello World");
//		return "hello";

	}

//	@Consumes(MediaType.APPLICATION_JSON)
	@RequestMapping(value = "/getString", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Message hello(@PathVariable("name") String name) {

		StringBuilder crunchifyBuilder = new StringBuilder();
		crunchifyBuilder.append(name);
		crunchifyBuilder.append(" --> Response");

		System.out.println("Data Received: " + crunchifyBuilder.toString());

		Message msg = new Message(name, crunchifyBuilder.toString());

		// return HTTP response 200 in case of success
		return msg;

	}

	@RequestMapping(value = "/ex/foos", method = RequestMethod.GET)
	@ResponseBody
	public String postFoos() {
		return "Post some Foos";
	}

	//url+ /ex/whatever as parameter
	@RequestMapping(value = "/ex/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String postFoos(@PathVariable("name") String name) {
		return "Post some Foos: " + name;
	}
}