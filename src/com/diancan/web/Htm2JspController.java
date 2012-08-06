package com.diancan.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Htm2JspController {
	@RequestMapping("addrest.htm")
	public String addRest(){
		return "addrest";
	}
	
	@RequestMapping("addfood.htm")
	public String addFood(){
		return "addfood";
	}
}
