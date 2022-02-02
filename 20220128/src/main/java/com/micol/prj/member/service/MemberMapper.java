package com.micol.prj.member.service;

import java.util.List;

import com.micol.prj.member.vo.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	int memberUpdate(MemberVO vo);
	
	boolean isIdcheck(String id);
}
