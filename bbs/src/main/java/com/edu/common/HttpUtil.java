package com.edu.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	public static void forward(HttpServletRequest req,HttpServletResponse res,String path) {
	RequestDispatcher rd = req.getRequestDispatcher(path);
	
	try {
		rd.forward(req, res);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
