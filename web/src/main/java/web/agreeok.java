package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2,	
		maxFileSize = 1024 * 1024 * 5,	//파일 용량이 5mb이상 될 경우 Server Down 됨
		maxRequestSize = 1024 * 1024 * 100	
	)
public class agreeok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String usermail = request.getParameter("usermail");
		String userphone = request.getParameter("userphone");
		String url = request.getServletContext().getRealPath("/upload/");
		String uploadfile = null;
		Collection<Part> agree = request.getParts();
		//System.out.println(url);
		
		for(Part p : agree) {
			String filename = p.getSubmittedFileName();
			long filesize = p.getSize();
			if(filename != null && !filename.isEmpty() && filesize < 2097152) {
				uploadfile = filename;
				p.write(url + filename);
			}
		}
		
		request.setAttribute("id", userid);
		request.setAttribute("name", username);
		request.setAttribute("email", usermail);
		request.setAttribute("number", userphone);
		
		RequestDispatcher rd = request.getRequestDispatcher("/agreeok.jsp");
		rd.forward(request, response);
		}
		catch(Exception e) {
			pw.write("<script>"
					+ "alert('회원가입 정보를 다시 확인해주세요');"
					+ "history.go(-1);"
					+ "</script>");
	
		}
	}
}
