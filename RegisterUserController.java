package com.nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nucleus.dao.IUserDao;
import com.nucleus.dao.UserRDBMSDaoImpl;
import com.nucleus.model.User;

/**
 * Servlet implementation class RegisterUserController
 */
@WebServlet("/RegisterUserController")
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterUserController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		RequestDispatcher rd=null;
		PrintWriter out=response.getWriter();
		User user=new User();
		user.setUserId(request.getParameter("uid"));
		user.setUserName(request.getParameter("uname"));
		user.setPassword(request.getParameter("pwd"));
		user.setGender(request.getParameter("gen"));
		
		IUserDao iudao=new UserRDBMSDaoImpl();
		boolean check=iudao.checkValidUser(user);
		  if(check==true)
		  {	  
		iudao.insertDetails(user);
		rd=request.getRequestDispatcher("Regsuccess");
		rd.forward(request, response);
		
		  }
		  
		 else
			out.println("USER ID ALREADY EXISTS TRY AGAIN USING ANOTHER ID");
	}

}
