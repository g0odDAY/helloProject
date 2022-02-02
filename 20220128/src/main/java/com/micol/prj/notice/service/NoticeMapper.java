package com.micol.prj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.micol.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	void noticeHitUpdate(int id);
	List<NoticeVO> noticeSearch(@Param("key")String key,@Param("str")String str);
}
