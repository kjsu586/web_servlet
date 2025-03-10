package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10,	
		maxFileSize = 1024 * 1024 * 20,
		maxRequestSize = 1024 * 1024 * 100	
	)
public class io_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PrintWriter pw = null;   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		try {
			String mfile = req.getParameter("mfile");
			String url = req.getServletContext().getRealPath("/io_ok/");
			System.out.println(url);
			req.setAttribute("mfile", mfile);
			
		} catch (Exception e) {
			
		}
		
	
	}

}
