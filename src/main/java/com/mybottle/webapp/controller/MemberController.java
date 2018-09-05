package com.mybottle.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybottle.webapp.dao.mybatis.MybatisMemberDao;
import com.mybottle.webapp.dao.mybatis.mapper.MemberDao;
import com.mybottle.webapp.entity.Member;

/*@Controller
@RequestMapping("/member/")*/
public class MemberController {
	
	@Autowired
	private MemberDao memberDao = new MybatisMemberDao();

	@GetMapping("join")
	public String join(Model model) {
		
		Member member = memberDao.get("newlec");
		
		
		model.addAttribute("member", member);
		//∫‰ ∆‰¿Ã¡ˆ
		return "member.join";
	}
	
	@GetMapping("login")
	public String login() {
		
		return "member.join";
	}
		
}
