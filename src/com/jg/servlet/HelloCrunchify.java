package com.jg.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		ApacheHttpClientGet atpc = new ApacheHttpClientGet();
		int categoryId = Integer.parseInt(request.getParameter("services"));
		System.out.println("selection: " + categoryId);
		StringBuilder sb = new StringBuilder();
		switch (Integer.valueOf(categoryId)) {
		case 1: {
			
			atpc.setRunVersion(new Integer(categoryId));
		}
		case 2: {
			atpc.setRunVersion(new Integer(categoryId));
		}
		case 3: {
			atpc.setRunVersion(new Integer(categoryId));
		}
		default: {
			atpc.setRunVersion(new Integer(categoryId));
		}
	
		sb.append(atpc.runTheProcess());
		}
		String destination = "Results.jsp";
		RequestDispatcher requestDistDispather = request.getRequestDispatcher(destination);
		request.setAttribute("results", sb.toString());
		requestDistDispather.forward(request, response);
		// put a choice statement to do a service based off categoryId
		// request.setAttribute("selectedCatId", categoryId);

		// listCategory(request, response);
	}
}