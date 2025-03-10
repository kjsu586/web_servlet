package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class coupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       PrintWriter pw = null;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		this.pw = res.getWriter();
		try {
			String mid = req.getParameter("mid");
			String cnumber = req.getParameter("cnumber");
			
			if(cnumber.equals("A1316B1004") || cnumber.equals("C4024A0096") || cnumber.equals("B1987C3136")) {
				req.setAttribute("mid", mid);
				req.setAttribute("cnumber", cnumber);
				
				RequestDispatcher rd = req.getRequestDispatcher("./coupon.jsp");
				rd.forward(req, res);
			}
			else {
				this.pw.write("<script>"
						+ "alert('쿠폰번호를 확인해주세요');"
						+ "history.go(-1);"
						+ "</script>");
				
			}
			
			
		} catch (Exception e) {
			this.pw.write("<script>"
					+ "alert('잘못된 접근입니다.');"
					+ "history.go(-1);"
					+ "</script>");
		} finally {
			this.pw.close();
		}
		
	}
}