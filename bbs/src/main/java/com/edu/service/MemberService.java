package com.edu.service;

import java.util.List;

import com.edu.vo.MemberVO;

public interface MemberService {
	public boolean memberInsert(MemberVO vo);
	public boolean memberUpdate(MemberVO vo);
	
	public List<MemberVO> memberList();
	public MemberVO login(String id,String pw);
}
