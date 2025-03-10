package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.encry_model;


public class adminok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String adm_id = req.getParameter("adm_id");
		String adm_pw = req.getParameter("adm_pw");
		String adm_no = req.getParameter("adm_no");
		//Model을 이용하여 암호화된 내용을 복호화 진행
		encry_model em = new encry_model();
		String id = em.datadecode(adm_id).intern();	//해당 데이터를 복호화(Base64)
		String pw = em.datadecode(adm_pw).intern();
		String no = em.datadecode(adm_no).intern();
		if(id == "admin" && pw == "a1234" && no == "admin") {
			System.out.println("정상 로그인");
		}
		else {
			System.out.println("회원정보 다시 확인하세요");
		}
	}

}
