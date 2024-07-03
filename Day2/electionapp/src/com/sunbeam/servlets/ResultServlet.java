package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

@WebServlet("/result")
public class ResultServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Candidate> list = new ArrayList<>();
		try(CandidateDao candidateDao = new CandidateDaoImpl()){
			
			list = candidateDao.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidates Result</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Election Result</h2>");
		out.println("<table>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Candidate</th>");
		out.println("<th>Party</th>");
		out.println("<th>Votes</th>");
		out.println("</tr>");
		out.println("</thead>");
		for(Candidate c : list) {
			out.printf("<tr><td>%s</td><td>%s</td><td>%d</td></tr>",
					c.getName(),c.getParty(),c.getVotes());
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
