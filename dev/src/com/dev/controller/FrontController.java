package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 전체 애플리케이션의 컨트롤러 등록 관리 용도
 * *.do, *.action라는 이름을 붙임쓰.
 */
public class FrontController extends HttpServlet{
	HashMap<String, Controller> list;
	String charset = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// web.xml에 설정해 둔 init-param
		charset = config.getInitParameter("charset");
		
		
		// front 요청시 제일 처음 1번만 실행되는 메소드.
		list = new HashMap<String, Controller>();
		System.out.println("front init()");
//		list.put("/요청하는페이지이름.do", "컨트롤러");
		//		  └>/요청하는페이지이름.do  └>컨트롤러
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberList.do", new MemberListController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);
		
		String uri = req.getRequestURI();	// /dev/memberInsert.do
		String contextPath = req.getContextPath();	// /dev
		String path = uri.substring(contextPath.length());	// /memberInsert.do
		System.out.println(path);
		
		Controller sub = list.get(path);	// controller
		sub.excute(req, resp);
	}
}
