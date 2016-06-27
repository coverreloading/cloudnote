package com.cloudnote.dao;

import com.cloudnote.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface userDao {
	public void save(Connection conn, User user) throws SQLException;

	public void update(Connection conn, Long id, User user) throws SQLException;

	public void delete(Connection conn, User user) throws SQLException;
	
	/**
	 * 根据用户名和密码获取用户信息
	 * @param user
	 * @throws SQLException
	 *  sql:id user_name email password display_pic age sex phone
	 */


	public ResultSet get(Connection conn, User user)throws SQLException;
}
