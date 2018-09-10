package com.mybottle.webapp.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller("clientHomeController")
@RequestMapping("/client/")
public class HomeController {

	/*@Autowired
	private MemberDao memberDao;	*/
	
	
	@GetMapping("index")
	public String index() {
	
		return "client.index";		
	}

}
