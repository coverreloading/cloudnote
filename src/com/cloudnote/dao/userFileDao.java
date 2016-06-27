package com.cloudnote.dao;

import com.cloudnote.entity.UserFile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface userFileDao {
	public void save(Connection conn, UserFile userFile) throws SQLException;

	public void update(Connection conn, Long id, UserFile userFile) throws SQLException;

	public void delete(Connection conn, UserFile userFile) throws SQLException;
	
	/**
	 * 根据用户名和密码获取用户信息
	 * @param userFile
	 * @throws SQLException
	 * sql:id file_name file_url del_or_not file_time user_id
	 */
	public ResultSet get(Connection conn, UserFile userFile)throws SQLException;
}
