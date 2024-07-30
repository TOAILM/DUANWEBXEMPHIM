package com.Servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VideoDAO;
import com.entity.clipEntity;
import com.model.Videos;

@WebServlet("/adminLayout")
public class adminLayout extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VideoDAO dao =new VideoDAO();
		List<Videos> video = dao.findAll();
		req.setAttribute("items", video);
		req.getRequestDispatcher("/views/adminLayout.jsp").forward(req, resp);
	}
}
