package kr.co.greenart;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class MyContextListener implements ServletContextListener {
//	 왜? why??? 쓰는가 ???
//	Datasource 는 Connection pool을 구현하고 있다.
//	알아서 반환해주고 버려주고 한다 이 말이야~
	private static DataSource dataSource;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("웹 어플리케이션 시작시 이벤트가 발생합니다.");

		// 웹 어플리케이션 첫 구동 시 필요한 설정을 할 수 있음.
		ServletContext context = sce.getServletContext();

		String driver = context.getInitParameter("driver");
		String dburl = context.getInitParameter("dburl");
		String dbid = context.getInitParameter("dbid");
		String dbpw = context.getInitParameter("dbpw");

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(dburl);
		ds.setUsername(dbid);
		ds.setPassword(dbpw);

		dataSource = ds;
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}