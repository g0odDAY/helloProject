package com.edu.service;

import java.util.List;

import com.edu.vo.BulletinVO;
import com.edu.vo.ReplyVO;

public interface BulletinService {
	public List<BulletinVO> selectList();
	public BulletinVO selectOne(int bbsId);
	public BulletinVO insert(BulletinVO vo);
	public BulletinVO update(BulletinVO vo);
	public int delete(int bbsId);
	
	//댓글관련 메소드
	public List<ReplyVO> selectReplyList(int bbsId);
	public ReplyVO insertReply(ReplyVO vo);
	public boolean deleteReply(int rid);
}
