package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.UserDAO;
import com.model.Users;

@WebServlet("/views/editProfile")
public class editProfile extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		findAll(req, resp);
		req.getRequestDispatcher("editProfile.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
        
        String userId = req.getParameter("id");
        String newfullname = req.getParameter("fullname");
        String newemail = req.getParameter("email");
        String newpassword = req.getParameter("password");
        
        try {
            UserDAO userDao = new UserDAO();
            Users user = userDao.findByID(userId);
            
            if (user == null) {
            	req.setAttribute("messageid", "ID không được để trống !");
            	req.getRequestDispatcher("/views/editProfile.jsp").forward(req, resp);
            }
            user.setPassword(newpassword);
            user.setFullname(newfullname);
            user.setEmail(newemail);
            userDao.update(user);
            
            req.setAttribute("messagecapnhat", "Cập nhật tài khoản thành công!");
            req.getRequestDispatcher("/views/editProfile.jsp").forward(req, resp);
        } catch (Exception e) {
        	req.setAttribute("message", "Lỗi!");
            e.printStackTrace();
            req.getRequestDispatcher("/views/editProfile.jsp").forward(req, resp);
        }
    }
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Users user = new Users();
			BeanUtils.populate(user, request.getParameterMap());
			UserDAO dao = new UserDAO();
			dao.update(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			UserDAO dao = new UserDAO();
			List<Users> list = dao.findAll();
			request.setAttribute("users", list);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
}
