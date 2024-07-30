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
//
//import com.dao.UserDAO;
//import com.model.Users;
//import com.utils.JpaUtils;
//
///**
// *
// * @author ta2khu75
// */
//@WebFilter(urlPatterns = {"/admin/*"})
//public class Manager implements Filter {
//	UserDAO dao = new UserDAO();
//    @Override
//    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) sr;
//        HttpServletResponse resp = (HttpServletResponse) sr1;
////        String id = req.getSession().getAttribute("user").toString();
//        Users user = (Users) req.getSession().getAttribute("user");
//        if (user == null) {
//            resp.sendRedirect("/assignment/login");
//        } else {
//        	if(user.isAdmin()){
//                fc.doFilter(sr, sr1);
//            }else{
//                resp.sendRedirect("/assignment/login");
//            }
//        }
//    }
//
//}
