package com.tivansoft.muscat;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MuscatApplicationTests {

//	private static final String DRIVER = "org.mariadb.jdbc.Driver";
//	private static final String URL = "jdbc:mariadb://localhost:3306/justDoIt";
//	private static final String USER = "root";
//	private static final String PASSWORD = "1234";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://vue-muscat.czwt78mf7f1j.ap-northeast-2.rds.amazonaws.com:3306/vuemuscat?useSSL=false";
	private static final String USER = "admin";
	private static final String PASSWORD = "qlqjs0spro";

	@Test
	public void testDBConnection() throws Exception {
        // DBMS에게 DB 연결 드라이버의 위치를 알려주기 위한 메소드
        Class.forName(DRIVER);
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("[ Connect확인 ]" + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
    void contextLoads() {
    }

}
