package com.edu.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.service.BulletinService;
import com.edu.vo.BulletinVO;


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
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return bulletin;
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
		return null;
	}

	@Override
	public int delete(int bbsId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
