package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;

public class BulletinFormController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path="bulletin/bulletinForm.tiles";//bulletin폴더밑에
		HttpUtil.forward(req, res, path);
	}

}
