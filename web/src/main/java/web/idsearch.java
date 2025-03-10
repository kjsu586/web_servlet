package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class idsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");	//자바를 html 로 변화시킨다는 뜻
		PrintWriter pw = response.getWriter();
		
		try {
			String n = request.getParameter("name");
			String t = request.getParameter("tel");
			String e = request.getParameter("email");
			String id = "";
			
			RequestDispatcher rd = request.getRequestDispatcher("/idsearch.jsp");
			
			if(n.equals("홍길동") && t.equals("01010041919") && e.equals("hong@naver.com")) {
				id = "hong2025";
			}
			else {
				id = "가입정보가 확인되지 않습니다.";
			}
			
			request.setAttribute("id", id);
			rd.forward(request, response);	
			
		} catch (Exception e) {
			pw.write("<script>"
					+ "alert('올바른 값이 전달되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
	}
}
