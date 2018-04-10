package bba.com.a.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bba.com.a.model.Bb_AdminDto;
import bba.com.a.service.BbaMemberSerivce;
import bba.com.a.service.BbaStatisticService;
import bba.com.a.service.BbaStoreSerivce;

@Controller
public class BbaLoginController {
	private static final Logger logger = LoggerFactory.getLogger(BbaLoginController.class);
	
	@Autowired
	BbaMemberSerivce bbMemberService;
	
	@Autowired
	BbaStatisticService bbaStatisticService;
	
	/*--------------------------------------------------------------------------------------------
	 * 로그인 화면 (첫화면)
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="login.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(HttpServletRequest request, Model model) {
		logger.info("BbaMemberController login");
		
		//세션 초기화
		HttpSession session = request.getSession();
		session.removeAttribute("loginedId");
		
		return "login.tiles";
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 로그인후 메인
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="loginAf.do", method=RequestMethod.POST)
	public String loginAf(HttpServletRequest request, HttpServletResponse response,  Model model, Bb_AdminDto adminDto) {
		logger.info("BbaMemberController login");
		
		
		
		
		System.out.println("로그인 시 id : " + adminDto.getId());
		System.out.println("로그인 시 password : " + adminDto.getPassword());
		
		HttpSession session = request.getSession(true);
		session.setAttribute("imagePath", "http://192.168.110.88:8090/upload/");

	    /*// 요청 URI로 1depth path를 구한다.
		String reqUri = request.getRequestURI();
		String[] reqUris = reqUri.split("/");
		String firstPath = "";
		firstPath = reqUris[1];*/
		
		Bb_AdminDto admin = bbMemberService.loginAdminIdPw(adminDto);
		if(admin==null) {
			

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out;
			try {
				//실패시 창 띄우기
				out = response.getWriter();
				out.println("<script>alert('아이디/ 비밀번호를 확인하세요.'); history.go(-1);</script>");
	            out.flush(); 
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "redirect:/login.do";
		}else {
			
			session.setAttribute("loginedId", admin.getId()) ;
			session.setMaxInactiveInterval(60*60);
			
			model.addAttribute("msg", admin.getId()+" login 완료"); 
		    
			return "home.tiles";
		}
	}
	
	/*--------------------------------------------------------------------------------------------
	 * main 화면으로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="main.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String main(Model model) {
		logger.info("BbaMemberController login");
		return "home.tiles";
	}
	
	/*
 
    // 세션 생성
    session.setAttribute("name", id) ;
    session.setAttribute("addr", addr) ;
 
 
    // 세션 유지시간 설정(예 : 1시간)
    session.setMaxInactiveInterval(60*60)
 
    // 세션값 가져오기
    out.println(session.getAttribute("name");
    out.println(session.getAttribute("addr");
 
 
    // 세션값 삭제
    session.removeAttribute("addr")
 
 
    // 세션값 가져오기
    out.println(session.getAttribute("name");
 
    // 세션을 삭제했으므로 addr은 안나옴
    out.println(session.getAttribute("addr");
 
 
 
    // 세션 전체 무효화(로그아웃시 주로 사용)
    session.invalidate();*/


	
	

}












