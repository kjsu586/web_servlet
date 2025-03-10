package admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(	//enctype 설정 시 무조건 세팅해야 정상적으로 페이지 활성화 가능
	fileSizeThreshold =  1024 * 1024 * 10,
	maxFileSize = 1024 * 1024 * 50,
	maxRequestSize = 1024 * 1024 * 100
)
public class mobileok extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		String se = req.getParameter("security");	//hidden에 있는 값이 다를 경우
		if(!se.equals("m")) {	//hidden에 있는 
			PrintWriter pw = res.getWriter();
			pw.write("<script"
					+ "alert('Error');"
					+ "history.go(-1);"
					+ "</script>");
			pw.close();
		}else {	//hidden이 맞을 경우	
			try {
			new reviews(req,res); //데이터를 핸들링
			}catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}

class reviews{	//외부 클래스 사용 시 한글 깨짐 처리는 메인 doPost or doGet에서 처리
	PrintWriter pw = null;
	public reviews(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		this.pw = res.getWriter();
		String mname = req.getParameter("mname");	//고객명
		String pname = req.getParameter("pname");	//상품명
		String star = req.getParameter("star");		//별점
		String mtext = req.getParameter("mtext");	//리뷰내용
		Part p = req.getPart("mfile");		//리뷰 이미지
		String filename = p.getSubmittedFileName();
		
		/* 파일을 생성하고 싶을 때!
		String ori =  req.getServletContext().getRealPath("/review2/");
		File f = new File(ori);
		f.mkdir();
		*/
		
		//만약 리뷰를 올린 사람의 아이디 or 이름 + 리뷰를 등록한 년월일-시간 순으로 폴더가 생성되고 그 안에 사진과 리뷰가 등록되게 하려면?
		
		if(filename != "") {	//이미지가 첨부 되었을 경우
			String url = req.getServletContext().getRealPath("/review/");
			p.write(url + filename);
		}
		
		this.pw.write("<script>"
				+ "alert('정상적으로 리뷰가 등록되었습니다.');"
				+ "location.href='./mobile.html';"//history.go(-1) : 전에 작성한 내용 남아 있음 / location : 내용 다 지워짐
				+ "</script>");
	}
}