package com.mycomy.controller;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycomy.domain.EmailDTO;
import com.mycomy.domain.MemberVO;
import com.mycomy.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

// 수정할거 있음> 클래스명 생각해보고 변경하기

@Log4j
@AllArgsConstructor
@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	@Inject
	private PasswordEncoder cryptPassEnc;
	
	@Inject
	private MemberService service;
	
	@Inject
	private JavaMailSender mailSender;
	
	// 주요기능 : 회원기능
	
	
	//회원가입 폼 : /member/join -> jsp파일명
	@GetMapping("/join")
	public void join() {
		
	}
	
	//회원가입저장
	@PostMapping("/join")
	public String joinOk(MemberVO vo, RedirectAttributes rttr) throws Exception{
		
		// 비밀번호 암호화 (스프링 시큐리티 기능)
		vo.setMbsp_password(cryptPassEnc.encode(vo.getMbsp_password()));
		// 메일수신여부처리
		vo.setMbsp_receive(!StringUtils.isEmpty(vo.getMbsp_receive()) ? "Y" : "N");
		
		log.info("멤버정보: " +vo);
		
		service.join(vo); //제대로 적용되면 적용된 행값인 1을 반환
		
		return "redirect:/member/login";
	}
	
	
	//아이디중복체크
	@ResponseBody
	@GetMapping("/checkID")
	public ResponseEntity<String> checkID(@RequestParam("mbsp_id") String mbsp_id) throws Exception{
		
		String result = "";
		ResponseEntity<String> entity = null;
		
		result = StringUtils.isEmpty(service.checkID(mbsp_id)) ? "Y" : "N";
		
		entity = new ResponseEntity<String>(result, HttpStatus.OK);
		
		return entity;
		
	}
	
	//메일인증요청
	@ResponseBody
	@GetMapping("/sendMailAuth")
	public ResponseEntity<String> sendMailAuth(@RequestParam("mbsp_email") String mbsp_email, HttpSession session) {
		
		ResponseEntity<String> entity = null;
		
		String authCode = makeAuthCode();
		session.setAttribute("authCode", authCode);
		
		EmailDTO dto = new EmailDTO("docmall", "leeyumi0713@gmail.com", mbsp_email, "docmall 인증메일", authCode);
		
		MimeMessage message = mailSender.createMimeMessage();
		
		
		try {
			message.addRecipient(RecipientType.TO, new InternetAddress(mbsp_email));
			message.addFrom(new InternetAddress[] {new InternetAddress(dto.getSenderMail(), dto.getSenderName())});
			message.setSubject(dto.getSubject(), "utf-8");
			message.setText(dto.getMessage(), "utf-8");
			
			mailSender.send(message);
			
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	
	
	//메일인증요청 확인
	@ResponseBody
	@GetMapping("/mailAuthConfirm")
	public ResponseEntity<String> MailAuthConfirm(@RequestParam("uAuthCode") String uAuthCode, HttpSession session) {
		
		ResponseEntity<String> entity = null;
		
		String authCode = (String) session.getAttribute("authCode");
		
		if(authCode.equals(uAuthCode)) {
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}else {
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		
		return entity;
	}
	
	
	
	
	// 회원가입시 메일인증코드 생성
	private String makeAuthCode() {
		
		String authCode = "";
		
		for(int i=0; i<6; i++) {
			authCode += String.valueOf((int) (Math.random() * 9) + 1);
		}
		
		return authCode;
	}
	
	
	//회원수정 폼
	@GetMapping("/modify")
	public void modify(HttpSession session, Model model) throws Exception {
		
		MemberVO vo = (MemberVO) session.getAttribute("loginStatus");
		
		String mbsp_id = vo.getMbsp_id();
		
		/*
		MemberVO db_vo = service.login(mbsp_id);
		model.addAttribute("memberVO", db_vo);
		이거는 보통 한꺼번에 바로 아래처럼 씀*/
		model.addAttribute(service.login(mbsp_id));
	}
	
	
	//회원수정저장
	@PostMapping("/modify")
	public String modify(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception {
		
		String redirectURL = "";
		
		vo.setMbsp_receive(!StringUtils.isEmpty(vo.getMbsp_receive()) ? "Y" : "N");
		
		log.info("회원수정정보 : " + vo);
		
		MemberVO session_vo = (MemberVO) session.getAttribute("loginStatus");
		
		if(cryptPassEnc.matches(vo.getMbsp_password(), session_vo.getMbsp_password())) {
			
			service.modify(vo);
			
			redirectURL = "/";
			rttr.addFlashAttribute("msg", "modifyOk");
		}else {
			redirectURL = "/member/modify";
			rttr.addFlashAttribute("msg", "modifyFail");
			
		}
		return "redirect:" + redirectURL;
	}
	
	
	//회원삭제
	
	
	//로그인폼
	@GetMapping("/login")
	public void login() {
		
	}
	
	//로그인
	@ResponseBody
	@PostMapping("/login")
	public ResponseEntity<String> login(
			@RequestParam("mbsp_id") String mbsp_id,
			@RequestParam("mbsp_password") String mbsp_password,
			HttpSession session) throws Exception{
		
		String result = "";
		ResponseEntity<String> entity = null;
		
		MemberVO vo = service.login(mbsp_id);
		
		if(vo == null) {
			result = "idFail";
		}else {
			
			if(cryptPassEnc.matches(mbsp_password, vo.getMbsp_password())) {
				result = "success";
				
				session.setAttribute("loginStatus", vo);
				
			}else {
				result = "pwFail";
			}
		}
		
		entity = new ResponseEntity<String>(result, HttpStatus.OK);
		
		return entity;
		
	}
	
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	//마이페이지
	@GetMapping("/mypage")
	public void mypage() {
		
	}
	
	
	//아이디 찾기
	@GetMapping("/searchID")
	public void searchID() {
		
	}
	
	//비밀번호 찾기
	@GetMapping("/searchPW")
	public void searchPW() {
		
	}

}
