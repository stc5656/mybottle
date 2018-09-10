package com.mybottle.webapp.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	
	/*@Autowired
	private MemberDao memberDao;*/	
	
	
	@GetMapping("index")
	public String index(Model model) {
	
		/*Member member = memberDao.get("jojo");
		
		model.addAttribute("member", member);*/
		
		return "home.index";		
	}
}
