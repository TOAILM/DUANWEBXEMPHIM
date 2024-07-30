package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VideoDAO;
import com.model.Videos;

@WebServlet("/views/detailVideo")
public class detailVideo extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EntityManager em = com.utils.JpaUtils.getEntityManager();
	VideoDAO dao = new VideoDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		selectByID(id, req);
		req.getRequestDispatcher("detailVideo.jsp").forward(req, resp);
	}
	
	public void selectByID(String name, HttpServletRequest req) {
		List<Videos> items = dao.findAll();
		req.setAttribute("testID", name);
		req.setAttribute("itemID", items);
		ArrayList<Videos> selClip = new ArrayList<Videos>();
		ArrayList<Videos> listVideo = new ArrayList<Videos>();
		for (Videos item : items) {
			String itemId = item.getId().trim();
			if (itemId.equalsIgnoreCase(name)) {
				selClip.add(item);
			} else {
				listVideo.add(item);
			}
		}
		req.setAttribute("videoClip", selClip);
		req.setAttribute("items", listVideo	);
	}
}