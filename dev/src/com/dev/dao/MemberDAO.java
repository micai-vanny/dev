package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}