package event;
//database 환경설정 및 세팅값

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconfig2 {
	public static Connection info() throws Exception{
		//String database = "com.mysql.jdbc.Driver"; //v5.1, v5.5
		
		//mysql version에 연결 설정 파트
		String database = "com.mysql.cj.jdbc.Driver"; //v5.7~
		//mysql 연결 경로
		String dburl = "jdbc:mysql://localhost:3306/db";
		String user = "kjsu";	//mysql 아이디
		String passwd = "0624";	//mysql 패스워드
		
		Class.forName(database);	//어떤 라이브러리를 이용하여 DB에 접속할 것인지를 정하는 것
		//mysql -u 아이디 -p
		Connection con = DriverManager.getConnection(dburl,user,passwd);
		return con;
	}
}
