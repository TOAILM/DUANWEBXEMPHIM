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
import com.entity.clipEntity;
import com.model.Favorite;
import com.model.Users;
import com.model.Videos;

@WebServlet("/views/favorites")
public class favoriteVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManager em = com.utils.JpaUtils.getEntityManager();
	VideoDAO dao = new VideoDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users user = (Users) req.getSession().getAttribute("user");
		Users newUser = em.find(Users.class, user.getId());
		System.out.println(newUser.getId());
		List<Favorite> favorite1 = newUser.getFavorites();
		
		req.setAttribute("items", favorite1);
		req.getRequestDispatcher("layoutFavoritesVideo.jsp").forward(req, resp);
	}
}
