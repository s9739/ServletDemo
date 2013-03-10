package com.pl.sz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		PrintWriter writer = response.getWriter();
		
		HttpSession session = request.getSession();

		ServletContext context = session.getServletContext();
		
		
		String name = request.getParameter("name");		
		Integer count = (Integer) context.getAttribute("count");	
		
		if (count == null)
		{
			count = 0;
		}
		
		count +=1;	
			
		if (name !=null && !name.equals(""))
		{			
		session.setAttribute("name", name);
		context.setAttribute("name", name);
		
		}
		
		context.setAttribute("count", count);
		
		writer.println("<h1>Witaj Swiecie</h1>" 
		+ session.getAttribute("name") 
		+ "<h1>Witaj Context</h1>" 
		+ context.getAttribute("count"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
