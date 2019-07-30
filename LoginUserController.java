package com.nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.dao.IUserDao;
import com.nucleus.dao.UserRDBMSDaoImpl;
import com.nucleus.model.User;

/**
 * Servlet implementation class LoginUserController
 */
@WebServlet("/LoginUserController")
public class LoginUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		User user=new User();
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=null;
		user.setUserId(request.getParameter("uid"));
		user.setPassword(request.getParameter("pwd"));
		IUserDao iudao=new UserRDBMSDaoImpl();
		boolean check=iudao.checkValidLogin(user);
		if(check==true)
		{
			HttpSession session=request.getSession(false);
			if(session!=null)
			{
				out.println("<h1 style=color:red>Session with user id exists one user can login one time</h1>");
			}
			else
			{
				HttpSession newsession=request.getSession();
			newsession.setAttribute("uid",user.getUserId());
			//response.sendRedirect("Success");
			 rd=request.getRequestDispatcher("Success");
			 rd.forward(request, response);
			}
		}
		else
		{
			//response.sendRedirect("Invalid");
			rd=request.getRequestDispatcher("Invalid");
			rd.forward(request, response);
		}
		
	}

}
