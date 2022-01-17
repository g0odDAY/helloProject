package com.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.model.MemberVO;

public class MemberDAO extends DAO{
	//리스트
	public List<MemberVO> getMemberList(){
		connect();
		List<MemberVO> memberList=new ArrayList<>();
		String sql="select * from members";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO member=new MemberVO();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));
				member.setMail(rs.getString("mail"));
				memberList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return memberList;
		
	}
	//단건조회
	public MemberVO getMember(String id) {
		connect();
		String sql = "select * from members where id=?";
		MemberVO searchMember = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				searchMember =new MemberVO();
				searchMember.setId(rs.getString("id"));
				searchMember.setPasswd(rs.getString("passwd"));
				searchMember.setName(rs.getString("name"));
				searchMember.setMail(rs.getString("mail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return searchMember;
		
	}
	//입력.
	public void insertMember(MemberVO vo) {
		connect();
		String sql="insert into members (id,passwd,name,mail) values(?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3,vo.getName());
			pstmt.setString(4, vo.getMail());
			int r =pstmt.executeUpdate();
			System.out.println(r+"건 입렵");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//수정
	public void updateMember(MemberVO vo) {
		connect();
		String sql ="update members set passwd=?, name=?, mail=? where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,vo.getPasswd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getMail());
			pstmt.setString(4, vo.getId());
			int r=pstmt.executeUpdate();
			System.out.println(r+"건 수정");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//삭제
	public void deleteMember(String id) {
		connect();
		String sql="delete from members where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int r=pstmt.executeUpdate();
			System.out.println(r+"건 삭제");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	public MemberVO loginCheck(String id, String pw) {
		connect();
		String sql="select * from members where id=? and passwd=?";
		MemberVO member=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				member=new MemberVO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setMail(rs.getString("mail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return member;
	}
}
