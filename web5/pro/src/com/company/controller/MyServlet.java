package com.company.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class MyServlet implements Servlet{

	public void destroy() {
		// servlet消亡时做的事情
		System.out.println("我走了...");
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		// servlet产生时需要做的事情
		System.out.println("我来了......");
		
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// servlet服务内容
		System.out.println("客官,可以吗......");
		
	}

}
