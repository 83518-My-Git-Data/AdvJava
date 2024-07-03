package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

@WebServlet("/editcand")
public class EditCandidateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		Candidate c = null;
		try(CandidateDao candidate = new CandidateDaoImpl()){
			c = candidate.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login Failed!!</title>");
		out.println("</head>");
		out.println("<body>");
		out.printf("<form method='post' action='editcand'>");
		out.printf("Id:<input type='text' name='id' value='%d' readonly/>",c.getId());
		out.printf("Name:<input type='text' name='name' value='%s'/><br/><br/>",c.getName());
		out.printf("Party:<input type='text' name='party' value='%s'/><br/><br/>",c.getParty());
		out.printf("Votes:<input type='text' name='votes' value='%d' readonly/>",c.getVotes());
		out.printf("<input type='submit' value='Update Candidate'/>");
		out.printf("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		String name = req.getParameter("name");
		String party = req.getParameter("party");
		String voteStr = req.getParameter("votes");
		int votes = Integer.parseInt(voteStr);
		Candidate c = new Candidate(id,name,party,votes);
		try(CandidateDao candDao = new CandidateDaoImpl()){
			int count = candDao.update(c);
			String message = "Candidate Edited: " + count;
			req.setAttribute("message", message);
			RequestDispatcher rd = req.getRequestDispatcher("result");
			rd.forward(req, resp);
//			resp.sendRedirect("result");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
