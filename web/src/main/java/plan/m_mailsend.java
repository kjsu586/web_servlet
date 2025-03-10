package plan;

import java.sql.Connection;
import java.sql.PreparedStatement;

import shop.m_dbinfo;

public class m_mailsend {
	Connection con = null;
    PreparedStatement ps = null;
    m_dbinfo db = new m_dbinfo();
    
    public m_mailsend() {
    	try {
    		this.con = this.db.getConnection();
    		
		} catch (Exception e) {

		}
	}
    
}
