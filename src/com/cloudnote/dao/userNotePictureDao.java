package com.cloudnote.dao;

import com.cloudnote.entity.UserNotePicture;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

;

public interface userNotePictureDao {
	public void save(Connection conn, UserNotePicture userNotePicture) throws SQLException;

	public void update(Connection conn, Long id, UserNotePicture userNotePicture) throws SQLException;

	public void delete(Connection conn, UserNotePicture userNotePicture) throws SQLException;
	
	/**
	 * 根据用户名和密码获取用户信息
	 * @param userNotePicture
	 * @throws SQLException
	 * sql:id note_name content del_or_not note_time user_id
	 */
	public ResultSet get(Connection conn, UserNotePicture userNotePicture)throws SQLException;
}
