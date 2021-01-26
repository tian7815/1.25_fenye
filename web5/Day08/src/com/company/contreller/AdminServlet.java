package com.company.contreller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.entity.User;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class AdminServlet extends HttpServlet {

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
		UserService userService = new UserServiceImpl();
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("currentPage", 1);
		int allPage = 0;
		try {
			int rows = userService.queryRows();
			if(rows % 3 == 0){
				allPage = rows / 3;
			}else{
				allPage = rows / 3 + 1;
			}
			httpSession.setAttribute("allPage", allPage);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			List<User> userList = userService.queryUserByFenYe(0, 3);
			request.setAttribute("list", userList);
			request.getRequestDispatcher("WEB-INF/jsp/FenYe.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
