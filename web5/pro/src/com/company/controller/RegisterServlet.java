package com.company.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����ҵ���߼�
		//�й�ǰ��������Ϣȫ����װ��request������
		/*
		String ip = request.getRemoteAddr();
		int port = request.getRemotePort();
		System.out.println("ip: " + ip + " port: " + port);
		//
		String useAgent = request.getHeader("User-Agent");
		if(useAgent.toLowerCase().contains("chrome")){
			System.out.println("chrome");
		}else if(useAgent.toLowerCase().contains("firefox")){
			System.out.println("firefox");
		}else if(useAgent.toLowerCase().contains("msie")){
			System.out.println("ie");
		}else{
			System.out.println("���������");
		}
		*/
		//��̨���ַ���
		request.getRequestDispatcher("UpdateServlet").forward(request, response);
		//�ض���:�����
		//response.sendRedirect("WEB-INF/jsp/MyJsp.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("post....");
	}

}