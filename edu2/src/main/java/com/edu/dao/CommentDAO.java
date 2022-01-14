package com.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.model.CommentVO;



public class CommentDAO extends DAO {
	
	
	public boolean deleteComment(String id) {
		String sql="delete from comments where id=?";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
			int r=pstmt.executeUpdate();
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
	public List<CommentVO> selectAll() {
		String sql = "select * from comments order by id asc";
		connect();
		List<CommentVO> list = new ArrayList<CommentVO>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CommentVO vo = new CommentVO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;

	}

	public CommentVO insertComment(String name, String content) {
		// TODO Auto-generated method stub
		String sql = "select value from id_repository where name='COMMENT'";
		String insertSql = "insert into comments values(?,?,?)";
		String updateSql = "update id_repository set value =? where name='COMMENT'";
		CommentVO comment = null;
		connect();
		int seq = -1;
		try {
			// 시퀀스
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("value:"+rs.getInt("value"));
				seq = rs.getInt("value");
				System.out.println("seq:"+seq);

			}
			// 한건입ㅇ력
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setInt(1,seq);
			System.out.println("setInt:"+seq);
			pstmt.setString(2, name);
			pstmt.setString(3, content);
			int r = pstmt.executeUpdate();
			System.out.println(r + "건입력됨.");
			// 비정상 처리
			if (r < 1) {
				return null;
			}
			comment = new CommentVO();
			comment.setId(seq);
			comment.setName(name);
			comment.setContent(content);
			
			//시퀀스 증가처리
			pstmt = conn.prepareStatement(updateSql);
			pstmt.setInt(1, ++seq);
			System.out.println("update set seq:"+seq);
			r=pstmt.executeUpdate();
			if (r < 1) {
				return null;
			}
			//정상롼료
			return comment;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	public boolean updateComment(CommentVO vo) {
		String sql="update comments set name=?, content=? where id =?";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getId());
			int r =pstmt.executeUpdate();
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
	public CommentVO selectOne(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from comments where id=?";
		System.out.print("id:"+id);
		connect();
		CommentVO vo =null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				vo=new CommentVO(rs.getInt("Id"),rs.getString("name"),rs.getString("content"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		System.out.println("id:"+vo.getId()+"name:"+vo.getName()+"content:"+vo.getContent());
		return vo;
	}
}
