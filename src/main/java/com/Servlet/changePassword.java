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

@WebServlet("/views/changePassword")
public class changePassword extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public changePassword() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		findAll(req, resp);
		req.getRequestDispatcher("changePassword.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
        
        String userId = req.getParameter("id");
        String currentPassword = req.getParameter("current-password");
        String newPassword = req.getParameter("new-password");
        String confirmPassword = req.getParameter("confirm-password");
        
        try {
            UserDAO userDao = new UserDAO();
            Users user = userDao.findByID(userId);
            
            if (user == null) {
            	req.setAttribute("message", "null!");
            	req.getRequestDispatcher("/views/changePassword.jsp").forward(req, resp);
            }
            
            if (!user.getPassword().equals(currentPassword)) {
            	req.setAttribute("message", "Mật khẩu hiện tại không đúng!");
            	req.getRequestDispatcher("/views/changePassword.jsp").forward(req, resp);
            }
            
            if (!newPassword.equals(confirmPassword)) {
            	req.setAttribute("message", "Mật khẩu mới và mật khẩu xác nhận không khớp!"); 
            	req.getRequestDispatcher("/views/changePassword.jsp").forward(req, resp);
            }
            
            user.setPassword(newPassword);
            userDao.update(user);
            
            req.setAttribute("message", "Đổi mật khẩu thành công!");
            req.getRequestDispatcher("/views/changePassword.jsp").forward(req, resp);
        } catch (Exception e) {
        	req.setAttribute("message", "Lỗi!");
            e.printStackTrace();
            req.getRequestDispatcher("/views/changePassword.jsp").forward(req, resp);
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
