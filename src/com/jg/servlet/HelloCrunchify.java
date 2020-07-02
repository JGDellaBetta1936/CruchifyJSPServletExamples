package com.jg.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author Crunchify.com
 */

public class HelloCrunchify extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4285539176182901817L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// reading the user input
		System.out.println("in doGet:");
		String destination = "AvailableChoices.jsp";
		RequestDispatcher requestDistDispather = request.getRequestDispatcher(destination);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		request.setAttribute("uid", username);
		request.setAttribute("phrase", password);
		requestDistDispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("services"));
		System.out.println("selection: " + categoryId);
		 
	    //request.setAttribute("selectedCatId", categoryId);
	 
	    //listCategory(request, response);
	}
}