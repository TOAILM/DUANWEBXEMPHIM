///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package filter1;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author ta2khu75
// */
//@WebFilter(urlPatterns = {"/like/*", "/share/*", "/admin/*","/logout", "/user/videos", "/change"})
//public class Login implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) sr;
//        HttpServletResponse resp = (HttpServletResponse) sr1;
//        HttpSession session=req.getSession();
//	if(req.getRequestURI().contains("forget")){
//		
//	}
//        if (session.getAttribute("user") == null) {
//            resp.sendRedirect("/assignment/login");
//        }
//        else {
//            fc.doFilter(sr, sr1);
//        }
//    }
//}
