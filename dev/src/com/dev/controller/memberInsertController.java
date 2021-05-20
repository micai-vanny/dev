package com.dev.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class memberInsertController implements Controller{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 신규 회원 등록 기능 -> 등록 결과를 보여주는 페이지 : memberInsertOutput.jsp
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		
		// insert 
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMail(mail);
		
		// 서비스 로직 호출
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		request.setAttribute("member", member);
		
														//  ┌> 결과 포워딩할 페이지
		RequestDispatcher rd = request.getRequestDispatcher("result/memberInsertOutput.jsp");
		rd.forward(request, response);
		
	}
	
}
