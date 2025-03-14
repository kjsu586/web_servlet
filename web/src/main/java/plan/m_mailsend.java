package plan;

import java.sql.Connection;
import java.sql.PreparedStatement;

import shop.m_dbinfo;

public class m_mailsend {
	Connection con = null;
	PreparedStatement ps = null;
	String sql = "";
	int result = 0;
	
	m_dbinfo db = new m_dbinfo();
	
	public int mail_in(String to_name,String to_mail,String subject,String context) {
		try {
			this.con = this.db.getConnection();
			this.sql = "insert into kjsu_mail (midx,to_name,to_mail,subject,context,maildate) "
					+ "values ('0',?,?,?,?,now())";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, to_name);
			this.ps.setString(2, to_mail);
			this.ps.setString(3, subject);
			this.ps.setString(4, context);
			this.result = this.ps.executeUpdate();
		} catch (Exception e) {
			this.result = 0;
		} finally {
			try {
				this.con.close();
				this.ps.close();				
			} catch (Exception e) {
				System.out.println(e);
				//System.out.println("비정상적으로 데이터베이스가 접속해제되었습니다.");
			}
		}
	
		return this.result;
	}
	
}

