package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VideoDAO;
import com.entity.clipEntity;
import com.model.Videos;

@MultipartConfig
@WebServlet("/views/index")
public class LayoutUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EntityManager em = com.utils.JpaUtils.getEntityManager();
	VideoDAO dao = new VideoDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Videos> item = dao.findAll();
		req.setAttribute("items", item);
		req.getRequestDispatcher("index.jsp").forward(req, resp);;
	}
}
