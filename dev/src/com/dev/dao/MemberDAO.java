package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.dev.vo.MemberVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return dao;
	}
	
	// 연결처리 Connection 객체
	private void connect() {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	//resource 반환
	private void close() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 전체 조회
	public List<MemberVO> listMember(){
		connect();
		String sql = "select * from member_b order by 1";
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			psmt = conn.prepareStatement(sql); // psmt 객체로 sql 전달
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setMail(rs.getString("mail"));
				member.setPasswd(rs.getString("passwd"));
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memberList;
	}
	
	// 한건 조회
	public MemberVO searchMember(String id) {
		connect();
		String sql = "select * from member_b where id = ?";
		MemberVO member = null;
		try {
			psmt = conn.prepareStatement(sql); // psmt 객체로 sql 전달
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setMail(rs.getString("mail"));
				member.setPasswd(rs.getString("passwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return member;
	}
	
	// DB처리 기능.
	public void insertMember(MemberVO member) {
		connect();
		String sql = "insert into member_b(id, passwd, name, mail) values(?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPasswd());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getMail());
			
			int in = psmt.executeUpdate();
			System.out.println(in + "건 입력 완료.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	// 회원 정보 수정
	public MemberVO updateMember(MemberVO member) {
		connect();
		String sql = "update member_b set passwd = ?, name = ?, mail = ? where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, member.getPasswd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getMail());
			psmt.setString(4, member.getId());
			
			int up = psmt.executeUpdate();
			System.out.println(up+"건 수정완료.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return member;
	}
	
	// 회원 정보 삭제
	public void deleteMember(String id) {
		connect();
		String sql = "delete from member_b where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int del = psmt.executeUpdate();
			System.out.println(del + "건 삭제완료.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
