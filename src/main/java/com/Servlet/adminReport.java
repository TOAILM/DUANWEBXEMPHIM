package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Favorite;
import com.utils.JpaUtils;

@WebServlet("/adminReport/index")
public class adminReport extends HttpServlet{
	private static final long serialVersionUID = 1L;
//	private EntityManager em = JpaUtils.getEntityManager();

//	@Override
//	protected void finalize() throws Throwable {
//		em.close();
//		super.finalize();
//	}
//	
//	public adminReport() {
//		
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		favorites(req, resp);
		req.getRequestDispatcher("/views/adminReport.jsp").forward(req, resp);
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doPost(req, resp);
//	}
	
//	protected void favorites(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	    TypedQuery<Object[]> query = em.createNamedQuery("favorites.Report", Object[].class);
//	    List<Object[]> resultList = query.getResultList();
//	    req.setAttribute("resultList", resultList);
//	}

}
