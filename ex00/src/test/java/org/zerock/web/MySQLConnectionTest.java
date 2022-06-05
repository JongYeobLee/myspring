package org.zerock.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {
	
//	private static final String DRIVER = "com.mysql.jdbc.Driver";
//	private static final String URL = "jdbc:mysql://39.118.52.71:3306/book_ex";
//	private static final String USER = "root";
//	private static final String PW = "!sgs@one.12";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/book_ex";
	private static final String USER = "jylee";
	private static final String PW = "one.123";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)) {
//		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/book_ex?" +
//                "user=jylee&password=one.123")) {
			System.out.println(con);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
