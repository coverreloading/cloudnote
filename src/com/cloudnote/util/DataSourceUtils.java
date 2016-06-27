package com.cloudnote.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtils {

	private static ComboPooledDataSource cpds = new ComboPooledDataSource();

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	public static Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}

	// 与事务有关.
	public static Connection getConnectionByTransaction() throws SQLException {
		Connection con = tl.get();
		if (con == null) {
			con = cpds.getConnection();
			tl.set(con);
		}
		return con;
	}

	public static void close(Connection con) throws SQLException {
		if (con != null) {
			con.commit();
			con.close();
			tl.remove();
		}
	}

	public static DataSource getDataSource() {
		return cpds;
	}

}
