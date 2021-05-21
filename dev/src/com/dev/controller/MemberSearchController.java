package com.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한 건 조회 (id) -> 결과를 반환
		// MemberService -> MemberDAO()
		String id = request.getParameter("id");
		String job = request.getParameter("job"); // update에서 쓸 거임
		String path = null; // 처리 경로를 지정할 변수
		System.out.println(job);
		if (job.equals("search")) {
			path = "result/memberSearchOutput.jsp"; // search면 memberSearchOutput으로
		} else if (job.equals("update")) {
			path = "memberUpdate.jsp"; // update면 memberUpdate로
		} else if (job.equals("delete")) {
			path = "memberDelete.jsp"; 	// delete면 memberDelete로 이동
		}

		MemberService service = MemberService.getInstance();
		MemberVO member = service.memberSearch(id);

		request.setAttribute("member", member); // ┌>들어오는 결과에 따라 처리해야하는 경로가 다르므로
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
