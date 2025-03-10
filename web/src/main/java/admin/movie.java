package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class movie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String mname = request.getParameter("mname");
		String mnumber = request.getParameter("mnumber");
		String mcheck = request.getParameter("mcheck");
		String mdate = request.getParameter("mdate");
		
		ArrayList<String> movie = new ArrayList<String>();
		movie.add(mname);
		movie.add(mnumber);
		movie.add(mcheck);
		movie.add(mdate);
		
		request.setAttribute("movie", movie);
		request.setAttribute("mname", mname);
		request.setAttribute("mnumber", mnumber);
		request.setAttribute("mcheck", mcheck);
		request.setAttribute("mdate", mdate);
		
		RequestDispatcher rd = request.getRequestDispatcher("./movie.jsp");
		rd.forward(request, response);
		
	}
}
