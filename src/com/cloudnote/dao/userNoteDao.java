package com.cloudnote.dao;

import com.cloudnote.entity.UserNote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

;

public interface userNoteDao {
	public void save(Connection conn, UserNote userNote) throws SQLException;

	public void update(Connection conn, Long id, UserNote userNote) throws SQLException;

	public void delete(Connection conn, UserNote userNote) throws SQLException;
	
	/**
	 * 根据用户名和密码获取用户信息
	 * @param userNote
	 * @throws SQLException
	 * sql:id note_name content del_or_not note_time user_id
	 */
	public ResultSet get(Connection conn, UserNote userNote)throws SQLException;
}
