package com.mybottle.webapp.controller.member;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mybottle.webapp.dao.MemberDao;


import com.mybottle.webapp.entity.Member;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;

	@Autowired
	private JavaMailSender mailSender;

	@GetMapping("join")
	public String join(Model model) {

		Member member = memberDao.get("jojo");

		model.addAttribute("member", member);
		// 占쏙옙 占쏙옙占쏙옙占쏙옙
		return "member.join";
	}

	@GetMapping("join-email")
	public String joinEmail() {
		
			
		return "member.join-email";
	}

	/**
	 * @param email
	 * @return
	 */
	@PostMapping("join-email")
	public String joinEmail(String email, HttpServletResponse response) {

		// �씤利앸찓�씪 蹂대궡�뒗嫄�..	(sadfsdfsafdsa243141dsfg �씠�윴嫄�)	
		UUID uuid = UUID.randomUUID();
		MessageDigest salt = null;
		String digest = null;

		try {

			salt = MessageDigest.getInstance("SHA-256"); // �븫�샇�솕 湲곕쾿 以묒뿉 �븯�굹
			salt.update(uuid.toString().getBytes());

			byte[] key = salt.digest();

			// 諛붿씠�듃�뿴�쓣 臾몄옄�뿴濡� 諛붽씀湲� �쐞�빐�꽌 �뜑�븯湲곌� 諛섎났�릺�뼱�빞 �븳�떎.
			StringBuilder builder = new StringBuilder();

			for (byte b : key)
				builder.append(String.format("%02x", b));

			digest = builder.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

		}

		/* uuid.toString(); */

		System.out.println(email);
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;

		System.out.println(uuid);
		System.out.println(digest);
		System.out.println(email);
		
		Cookie cookie = new Cookie("joinId", digest);
		cookie.setPath("/member/"); // 寃쎈줈�뒗 臾댁뒯 �슜�룄�깘??
		cookie.setMaxAge(60*60*24); //�떒�쐞;?		
		
		response.addCookie(cookie);		
		
		try {
			helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("noreply@newlecture.com");
			helper.setTo(email);
			helper.setSubject("dfgdfgdg");
			helper.setText("<a href=\"http://211.238.142.36:8080/member/join-reg?id="+digest+"&em="+email+"\">dfgdfgdfgd</a>", true);

		} catch (MessagingException e) {

			e.printStackTrace();

		}
		
		// �씠寃껊쭔 �깉濡� �꽭�똿�븯怨� �쐞�뿉爰쇰뒗 洹몃�濡� �몢硫대맖!!
		/*mailSender.send(message);*/

		return "member.join-email-info";
	}

	/*------------------------------------------*/

	@GetMapping("join-reg")
	public String joinReg(@RequestParam(value="id", defaultValue="") String key
			, @RequestParam(value="em", defaultValue="") String email
			, @CookieValue(value="joinId", defaultValue="") String joinId
			, Model model) {		
		
		// �씠硫붿씪 �씤利� 怨쇱젙 以� �삤瑜� 諛쒖깮
		if(key.equals("") || joinId.equals("") || !key.equals(joinId))
			return "member.join-error";
		
		String uid = email.substring(email.lastIndexOf("@")+1);  // newlec@namoolab.com �뿉�꽌 �븵�뿉 newlec留� 諛쒖톸�븯�뒗 肄붾뱶
				
		model.addAttribute("uid", uid);
		model.addAttribute("email", email);
				
		return "member.join-reg";		
	}
	
	@GetMapping("login")
	public String login() {

		return "member.login";
	}

}