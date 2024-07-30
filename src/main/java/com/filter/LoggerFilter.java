//package com.filter;
//
//import java.io.IOException;
//
//import java.util.Date;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.model.Users;
//
//@WebFilter(filterName = "LoginFilter", urlPatterns = { ("/Nhom6_ASM1/views/login") })
//public class LoggerFilter implements HttpFilter {
//
//	@Override
//	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
//			throws IOException, ServletException {
//		Users user = (Users) req.getSession().getAttribute("user");
//		String uri = req.getRequestURI();
//		Date time = new Date();
//		// code
//		chain.doFilter(req, resp);
//	}
//
//}
