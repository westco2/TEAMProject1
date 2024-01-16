package com.project.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter({"/main/write.post", "/main/attention.post", "/main/write.scripts"})
public class postFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		request.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("user_id");
		if(id == null) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('로그인해주세요');");
			out.println("location.href='login.user';");
			out.println("</script>");
			return;
		}
		chain.doFilter(request, response);
		
	}

}
