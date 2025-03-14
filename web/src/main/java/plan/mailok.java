package plan;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mailok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	m_mailsend ms = new m_mailsend();
	PrintWriter pw = null;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String to_name = request.getParameter("to_name");
		String to_mail = request.getParameter("to_mail");
		String subject = request.getParameter("subject");
		String context = request.getParameter("context");
		
		int result = this.ms.mail_in(to_name,to_mail,subject,context);
		this.pw = response.getWriter();
		if(result > 0) {
			this.pw.write("<script>"
					+ "alert('정상적으로 제휴 문의가 등록되었습니다.');"
					+ "location.href='./mail_list.do';"
					+ "</script>");
		}
		else {
			this.pw.write("<script>"
					+ "alert('오류가 발생했습니다..');"
					+ "history.go(-1);"
					+ "</script>");
			
		}
		
	}

}
