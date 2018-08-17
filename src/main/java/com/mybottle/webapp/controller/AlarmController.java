package com.mybottle.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlarmController {
	@RequestMapping("/client/alarm/reg")
	public String aaaaaaa() {
				
		return "/WEB-INF/views/client/alarm/reg.jsp";
		
	}
}
