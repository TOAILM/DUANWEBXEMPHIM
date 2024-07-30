package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.UserDAO;
import com.model.Users;

@WebServlet({ "/adminUserManage/index", "/adminUserManage/create", "/adminUserManage/update", "/adminUserManage/delete",
		"/adminUserManage/reset", "/adminUserManage/edit/*", "/adminUserManage/delete/*", })
public class adminUserManage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public adminUserManage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();

		req.setCharacterEncoding("utf-8");

		Users user = null;

		if (url.contains("delete")) {
			UserDAO dao = new UserDAO();
			if (req.getParameter("id") != null) {
				dao.Remove(req.getParameter("id"));
				req.setAttribute("message", "Delete success!");
			}
			// xóa rỗng các ô texbox
			user = new Users();
			req.setAttribute("user", user);
		}

		else if (url.contains("edit")) {
			UserDAO dao = new UserDAO();
			if (req.getParameter("id") != null)
				user = dao.findByID(req.getParameter("id"));
			req.setAttribute("user", user);
		}

		findAll(req, resp);
		req.getRequestDispatcher("/views/adminUserManage.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURL().toString();
		request.setCharacterEncoding("utf-8");
		Users user = new Users();
		if (url.contains("create")) {
			create(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("reset")) {
			request.setAttribute("user", new Users());
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/adminUserManage.jsp").forward(request, response);
	}

	protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Users user = new Users();
			BeanUtils.populate(user, req.getParameterMap());
			UserDAO dao = new UserDAO();
			dao.create(user);
			req.setAttribute("message", "Create success!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Users user = new Users();
			BeanUtils.populate(user, req.getParameterMap());
			String adminParam = req.getParameter("role");
			boolean isAdmin = "admin".equals(adminParam);
			user.setAdmin(isAdmin);
			System.out.println(user.isAdmin());
			UserDAO dao = new UserDAO();
			dao.update(user);
			req.setAttribute("message", "Update success!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Users user = new Users();
			BeanUtils.populate(user, req.getParameterMap());
			UserDAO dao = new UserDAO();
			if (user.getId() != null)
				dao.Remove(user.getId());
			req.setAttribute("message", "Delete success!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			UserDAO dao = new UserDAO();
			List<Users> list = dao.findAll();
			req.setAttribute("users", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}
