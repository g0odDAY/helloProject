package com.edu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.BulletinService;
import com.edu.serviceImpl.BulletinDAO;
import com.edu.vo.BulletinVO;

public class BulletinListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path="bulletin/bulletinList.tiles";
		BulletinService service=new BulletinDAO();
		List<BulletinVO> list=service.selectList();
		req.setAttribute("bulletinList", list);
		HttpUtil.forward(req, res,path);
		
	}

}
