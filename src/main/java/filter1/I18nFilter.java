//package filter1;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class I18nFilter extends HttpFilter {
//
//	@Override
//	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
//		String lang = req.getParameter("lang");
//		if (lang != null) {
//			req.getSession().setAttribute("lang", lang);
//		}
//		chain.doFilter(req, resp);
//	}
//}
