package com.mybottle.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client/alarm")
public class AlarmController {
	@RequestMapping("reg")
	public String aaaaaaa() {
				
		return "client.alarm.reg";
				
	}
	
	@RequestMapping("type")
	public String bbbbbb() {
				
		return "client.alarm.type";
		
	}
}
