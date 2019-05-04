package com.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController 
{
	@RequestMapping(value="/") 
	public String displayIndex()
	{
		return "index";
	}
	
	@RequestMapping(value="/login") 
	public String displayLogin()
	{
		return "Login";
	}
	
	@RequestMapping(value="/register") 
	public String displayRegister()
	{
		return "Register";
	}
	
	@RequestMapping(value="/contactus") 
	public String displayContactUs()
	{
		return "ContactUs";
	}
	
	@RequestMapping(value="/aboutus") 
	public String displayAboutUs()
	{
		return "AboutUs";
	}
	
}