package com.dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberListController implements Controller {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체 횐님덜 조회 @>-----
		// memberListOutput.jsp로 출력
		
		MemberService service = MemberService.getInstance();
		List<MemberVO> list = service.memberList();
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("result/memberListOutput.jsp");
		rd.forward(request, response);
		

	}

}
