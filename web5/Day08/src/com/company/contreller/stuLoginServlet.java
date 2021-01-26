package com.company.contreller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class stuLoginServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("idtext").trim();
		String uname = request.getParameter("passtext").trim();
		UserService us = new UserServiceImpl();
		String pwd ="";
		try {
			pwd = us.stuLogin(uid);
			if(pwd.equals("")){
				String msg = "’À∫≈”–ŒÛ";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("StuLoginPage.jsp").forward(request, response);
			}else{
				if(pwd.equals(uname)){
					System.out.println("µ«¬º≥…π¶");
		
				}else{
					String msg2 = "√‹¬Î”–ŒÛ";
					request.setAttribute("msg", msg2);
					request.getRequestDispatcher("StuLoginPage.jsp").forward(request, response);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
