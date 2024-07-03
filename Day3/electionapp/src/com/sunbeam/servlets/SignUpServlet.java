package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>SignUp</title>");
		out.println("</head>");
		out.println("<body>");
		out.printf("<form method='post' action='signup'>");
		out.printf("First Name:<input type='text' name='first_name' required/><br/><br/>");
		out.printf("Last Name:<input type='text' name='last_name' required/><br/><br/>");
		out.printf("Email:<input type='text' name='email' required/><br/><br/>");
		out.printf("Password:<input type='password' name='password' required/><br/><br/>");
		out.printf("Date Of Birth:<input type='date' name='dob' required/><br/><br/>");
		out.printf("<input type='submit' value='Sign Up'/>");
		out.printf("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("first_name");
		String lastName = req.getParameter("last_name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String dobStr = req.getParameter("dob");
		Date birth = Date.valueOf(dobStr);
		
		int status = 0;
		String role = "voter";
		
		User u = new User(firstName,lastName,email,password,birth,status,role);
		try(UserDao user = new UserDaoImpl()){
			int count = user.save(u);
			if(count > 0) {
				resp.sendRedirect("index.html");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
		
	
	

}
