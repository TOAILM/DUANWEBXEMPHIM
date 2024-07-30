package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.model.Users;

@WebServlet({"/views/login", "/views/sign-in"})
public class loginUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String error=req.getParameter("error");
		req.getSession().setAttribute("user", null);

		req.getRequestDispatcher("loginUser.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String uri = req.getRequestURI();

		if (uri.contains("sign-in")) {
			signIn(req, resp);
		} else if (uri.contains(uri)){
			logout(req, resp);
		}
	}

	private void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			String pw = req.getParameter("password");

			System.out.println(id);
			System.out.println(pw);
			UserDAO dao = new UserDAO();

			Users user = dao.findByID(id);
			System.out.println("user: " + user.getId());
			System.out.println("pw : " + user.getPassword());
//			if(user != null) {
			if (!user.getPassword().equalsIgnoreCase(pw)) {
				req.setAttribute("message", "Sai mật khẩu!");
				req.getRequestDispatcher("/views/loginUser.jsp").forward(req, resp);
			} else {
				req.getSession().setAttribute("messageHomePage", "Đăng Nhập thành công");

				req.getSession().setAttribute("user", user);

				Users checkUser = (Users) req.getSession().getAttribute("user");
				
				if (checkUser.isAdmin()) {
					resp.sendRedirect(req.getContextPath() + "/adminLayout");
				} else {
					resp.sendRedirect(req.getContextPath() + "/views/index");
				}
			}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users user = null;
		req.getSession().setAttribute("user", user);
		req.getRequestDispatcher("loginUser.jsp").forward(req, resp);
	}
}
