package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class deliveryok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter pw = null;
	//HttpServletRequest request;
	//HttpServletResponse response;

	public deliveryok() {
		/*
		try {
			this.request.setCharacterEncoding("utf-8");
			this.response.setContentType("text/html;charset=utf-8");
			this.pw = response.getWriter();
		} catch (Exception e) {
			
		}
		 */
	}
	
	
	//즉시실행 메소드(Servlet) : 일반 class에서 사용하는 형태와는 구조가 다르다
	//void를 사용했기 때문에 일반 메소드
    public void deliveryok(HttpServletRequest request, HttpServletResponse response) {	//action에서 해당 class를 실행하면 즉시 실행 메소드 호출
        try {
        	request.setCharacterEncoding("utf-8");
        	response.setContentType("text/html;charset=utf-8");
        	this.pw = response.getWriter();
		} catch (Exception e) {
			System.out.println("해당 URL 경로가 올바르지 않습니다.");
		}
    }
    
	//매개변수명을 변경하여 request, response를 다른 이름으로 변경 가능
	protected void doPost(HttpServletRequest res, HttpServletResponse rep) throws ServletException, IOException {
		this.deliveryok(res, rep);
		String mname = res.getParameter("mname");
		String mtel = res.getParameter("mtel");
		String memail = res.getParameter("memail");
		String maddress = res.getParameter("maddress");
		//클래스 배열 사용 이유 : setAttribute 개수가 많은 상태에서 jsp에 넘겨주면 getAttribute 숫자도 너무 많아짐
		ArrayList<String> data = new ArrayList<String>();
		data.add(mname);
		data.add(mtel);
		data.add(memail);
		data.add(maddress);
		
		//클래스 배열로 jsp에 전달
		res.setAttribute("data", data); //(jsp가 받을 이름, 보낼 데이터)
		
		RequestDispatcher rd = res.getRequestDispatcher("./deliveryok.jsp");
		rd.forward(res, rep);
	}

}



















