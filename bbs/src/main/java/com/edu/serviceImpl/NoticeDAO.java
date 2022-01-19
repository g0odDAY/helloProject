package com.edu.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.service.NoticeService;
import com.edu.vo.NoticeVO;

public class NoticeDAO extends DAO implements NoticeService {

	@Override
	public List<NoticeVO> selectList() {
		List<NoticeVO> list=new ArrayList<>();
		connect();
		String sql="select * from notice order by notice_id asc";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO vo=new NoticeVO();
				
				vo.setNoticeId(rs.getString("notice_id"));
				vo.setNoticeTitle(rs.getString("notice_title"));
				vo.setNoticeContent(rs.getString("notice_content"));
				vo.setNoticeDate(rs.getString("notice_wdate"));
				vo.setNoticeHit(rs.getInt("notice_hit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public NoticeVO selectOne(int noticeId) {
		connect();
		NoticeVO vo=null;
		String sql="select * from notice where notice_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, noticeId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo=new NoticeVO();
				vo.setNoticeId(rs.getString("notice_id"));
				vo.setNoticeTitle(rs.getString("notice_title"));
				vo.setNoticeContent(rs.getString("notice_content"));
				vo.setNoticeDate(rs.getString("notice_wdate"));
				vo.setNoticeHit(rs.getInt("notice_hit"));
				updateCount(noticeId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	//조회수증가
		public void updateCount(int id) {
			connect();
			String sql="update notice set notice_hit = notice_hit+1 where notice_id=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				int r=pstmt.executeUpdate();
				System.out.println("조회수"+r+"건증가");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				disconnect();
			}
		}
	@Override
	public NoticeVO insert(NoticeVO vo) {
		connect();
		String sql1="select notice_seq.nextval from dual";
		String sql2="insert into notice (notice_id,notice_title,notice_content,notice_wdate,notice_hit)"
				+"values(?,?,?,sysdate,0)";
		try {
			pstmt=conn.prepareStatement(sql1);
			rs=pstmt.executeQuery();
			int seq=0;
			if(rs.next()) {
				seq=rs.getInt(1);
			}
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, seq);
			pstmt.setString(2, vo.getNoticeTitle());
			pstmt.setString(3, vo.getNoticeContent());;
			int r=pstmt.executeUpdate();
			System.out.println("공지"+r+"건 입력완료.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public NoticeVO update(NoticeVO vo) {
		connect();
		String sql="update notice set notice_title=?,notice_content=?"
				+ "where notice_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNoticeTitle());
			pstmt.setString(2, vo.getNoticeContent());
			pstmt.setString(3, vo.getNoticeId());
			int r=pstmt.executeUpdate();
			System.out.println("공지"+r+"건변경");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int delete(int noticeId) {
		connect();
		String sql="delete from notice where notice_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, noticeId);
			int r=pstmt.executeUpdate();
			System.out.println("공지"+r+"건삭제");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return noticeId;
	}

}
