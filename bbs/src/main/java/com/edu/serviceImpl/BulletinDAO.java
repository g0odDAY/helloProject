package com.edu.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.service.BulletinService;
import com.edu.vo.BulletinVO;
import com.edu.vo.ReplyVO;


public class BulletinDAO extends DAO implements BulletinService{

	@Override
	public List<BulletinVO> selectList() {
		// TODO Auto-generated method stub
		connect();
		String sql="select * from bbs order by 1";
		List<BulletinVO> list=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BulletinVO bulletin=new BulletinVO();
				bulletin.setBbsId(rs.getInt("bbs_id"));
				bulletin.setBbsTitle(rs.getString("bbs_title"));
				bulletin.setBbsContent(rs.getString("bbs_content"));
				bulletin.setBbsImage(rs.getString("bbs_image"));
				bulletin.setBbsHit(rs.getInt("bbs_hit"));
				bulletin.setBbsCreateDate(rs.getString("bbs_create_date"));
				bulletin.setBbsWriter(rs.getString("bbs_writer"));
				list.add(bulletin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}

	@Override
	public BulletinVO selectOne(int bbsId) {
		connect();
		String sql="select * from bbs where bbs_id=?";
		BulletinVO bulletin=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bbsId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bulletin=new BulletinVO();
				bulletin.setBbsId(rs.getInt("bbs_id"));
				bulletin.setBbsTitle(rs.getString("bbs_title"));
				bulletin.setBbsContent(rs.getString("bbs_content"));
				bulletin.setBbsImage(rs.getString("bbs_image"));
				bulletin.setBbsHit(rs.getInt("bbs_hit"));
				bulletin.setBbsCreateDate(rs.getString("bbs_create_date"));
				bulletin.setBbsWriter(rs.getString("bbs_writer"));
				//카운트 증가
				updateCount(bbsId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return bulletin;
	}
	
	//조회수증가
	public void updateCount(int id) {
		connect();
		String sql="update bbs set bbs_hit = bbs_hit+1 where bbs_id=?";
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
	public BulletinVO insert(BulletinVO vo) {
		connect();
		String sql1="select bbs_id_seq.nextval from dual";
		String sql2="insert into bbs (bbs_id,bbs_title,bbs_content,bbs_writer,bbs_image,bbs_create_date,bbs_hit)"
				+ "values(?,?,?,?,?,sysdate,0)";
		try {
			pstmt=conn.prepareStatement(sql1);
			rs=pstmt.executeQuery();
			int seq=0;
			if(rs.next()) {
				seq=rs.getInt(1);
			}
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, seq);
			pstmt.setString(2, vo.getBbsTitle());
			pstmt.setString(3, vo.getBbsContent());
			pstmt.setString(4, vo.getBbsWriter());
			pstmt.setString(5,vo.getBbsImage());
			int r=pstmt.executeUpdate();
			System.out.println(r+"건입력");
			
			vo.setBbsId(seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return vo;
	}

	@Override
	public BulletinVO update(BulletinVO vo) {
		// TODO Auto-generated method stub
		connect();
		String sql="update bbs set bbs_title=?, bbs_content=?, bbs_image=nvl(?,bbs_image) where bbs_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBbsTitle());
			pstmt.setString(2,vo.getBbsContent());
			pstmt.setString(3, vo.getBbsImage());
			pstmt.setInt(4, vo.getBbsId());
			int r=pstmt.executeUpdate();
			System.out.println(r+"건변경");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return vo;
	}

	@Override
	public int delete(int bbsId) {
		connect();
		String sql="delete from bbs where bbs_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bbsId);
			int r=pstmt.executeUpdate();
			System.out.println(r+"건삭제");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return bbsId;
	}

	@Override
	public List<ReplyVO> selectReplyList(int bbsId) {
		connect();
		String sql="select * from reply where bbs_id=?";
		List<ReplyVO> rList=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bbsId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ReplyVO vo=new ReplyVO();
				vo.setBbsId(rs.getInt("bbs_id"));
				vo.setReplyContent(rs.getString("reply_content"));
				vo.setReplyDate(rs.getString("reply_date"));
				vo.setReplyId(rs.getInt("reply_id"));
				vo.setReplyWriter(rs.getString("reply_writer"));
				rList.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return rList;
	}

	@Override
	public ReplyVO insertReply(ReplyVO vo) {
		String sql1="select reply_id_seq.nextval, sysdate from dual";
		String sql2="insert into reply (reply_id,reply_content,reply_writer,reply_date,bbs_id)"
				+ "values(?,?,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),?)";
		connect();
		try {
			pstmt=conn.prepareStatement(sql1);
			rs=pstmt.executeQuery();
			int replySeq=0;
			String replyDate="";
			if(rs.next()) {
				replySeq = rs.getInt(1);
				replyDate=rs.getString(2);
			}
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, replySeq);
			pstmt.setString(2, vo.getReplyContent());
			pstmt.setString(3, vo.getReplyWriter());
			pstmt.setString(4, replyDate);
			pstmt.setInt(5, vo.getBbsId());
			
			int r=pstmt.executeUpdate();
			System.out.println(r+"건입력.");
			vo.setReplyId(replySeq);
			vo.setReplyDate(replyDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return null;
	}

	@Override
	public boolean deleteReply(int rid) {
		// TODO Auto-generated method stub
		String sql="delete from reply where reply_id=?";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, rid);
			int r=pstmt.executeUpdate();
			System.out.println(r+"건 댓글삭제!");
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return false;
	}
	
}
