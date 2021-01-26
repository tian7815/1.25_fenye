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

public class DownServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		int currentPage = (Integer) httpSession.getAttribute("currentPage");
        //System.out.println("test: " + currentPage);
		int allPage = (Integer) httpSession.getAttribute("allPage");
		UserService userService = new UserServiceImpl();
		currentPage ++;
		 if(currentPage < allPage){
				try {
					List<User> userList = userService.queryUserByFenYe((currentPage - 1)* 3, 3);
					request.setAttribute("list", userList);
					httpSession.setAttribute("currentPage", currentPage);
					request.setAttribute("downMSG", "下一页");
					request.getRequestDispatcher("WEB-INF/jsp/FenYe.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
		 }else{
			 currentPage=allPage;
			 List<User> userList;
			try {
				userList = userService.queryUserByFenYe((currentPage - 1) * 3, 3);
				request.setAttribute("list", userList);
				httpSession.setAttribute("currentPage", currentPage);
				request.setAttribute("downMSG", "尾页");
				request.getRequestDispatcher("WEB-INF/jsp/FenYe.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
