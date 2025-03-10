package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/paylist.do")
public class paylist extends HttpServlet {
   private static final long serialVersionUID = 1L;
    
   PrintWriter pw = null;
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   request.setCharacterEncoding("utf-8");
   response.setContentType("text/html;charset=utf-8");
   
   try { 
      
      this.pw = response.getWriter();
      String[] basket = (String[])request.getParameterValues("basket");
      String[] price = (String[])request.getParameterValues("price");
      
      int i;
      int sum =0;
      for(i = 0;i < price.length ;i++) {
         sum += Integer.parseInt(price[i].trim());
      }
      
      String total = (String)request.getParameter("total");
      
      Integer.parseInt(total);
      
      if(Integer.parseInt(total) != sum) {
         this.pw.write("<script>"
               + "alert('최종 결제 금액이 잘못되었습니다.');"
               +"history.go(-1);"
               +"</script>"
               );   
            }
      
      request.setAttribute("basket", basket);
      request.setAttribute("price", price);
      request.setAttribute("total", total);
      
      RequestDispatcher rd = request.getRequestDispatcher("/payokDo.jsp");
      rd.forward(request, response);
      
      
      
   }catch(NumberFormatException nfe) {
      this.pw.write("<script>"
            + "alert('가격은 숫자로만 이루어져야합니다.');"
            +"history.go(-1);"
            +"</script>"
            );
      
   }
   
   
   catch(NullPointerException ne) {
      this.pw.write("<script>"
            + "alert('품목을 체크해주세요.');"
            +"history.go(-1);"
            +"</script>"
            );
      
   }
   
   
   catch(Exception e) {
      this.pw.write("<script>"
            + "alert('잘못된 입력입니다.');"
            +"history.go(-1);"
            +"</script>"
            );
      e.printStackTrace();
      
   }
   finally {
      this.pw.close();
   }
      
      
   }
}
