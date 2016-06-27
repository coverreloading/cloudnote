package com.cloudnote.dao;

import com.cloudnote.entity.ShareNote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

;

public interface shareNoteDao {
	public void save(Connection conn, ShareNote shareNote) throws SQLException;

	public void update(Connection conn, Long id, ShareNote userNote) throws SQLException;

	public void delete(Connection conn, ShareNote userNote) throws SQLException;
	
	/**
	 * 根据用户名和密码获取用户信息
	 * @param userNote
	 * @throws SQLException
	 * sql:id note_name content del_or_not note_time user_id
	 */
	public ResultSet get(Connection conn, ShareNote userNote)throws SQLException;
}
