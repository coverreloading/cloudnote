package com.cloudnote.impl;

import com.cloudnote.dao.userNoteDao;
import com.cloudnote.entity.UserNote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

;

public class userNoteImpl implements userNoteDao {
	
	//新建笔记
	public void save(Connection conn, UserNote userNote) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO user_note(noteName,content,delOrNot,noteTime) values (?, ?, ?,?)");
		ps.setString(1, userNote.getNoteName());
		ps.setString(2, userNote.getContent());
		ps.setInt(3, userNote.getDelOrNot());
		ps.setString(4, userNote.getNoteTime());
		ps.execute();

	}

	/**
	 * id    准备更新的笔记的ID
	 * UserNote  新的笔记信息
	 */
//  修改用户信息  可更改内容  笔记名 内容 删除标签 修改时间
	public void update(Connection conn, Long id, UserNote userNote) throws SQLException {
		String updateSql = "UPDATE user_note SET noteName=?, content=? ,delOrNot=? ,noteTime=? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(updateSql);
		ps.setString(1, userNote.getNoteName());
		ps.setString(2, userNote.getContent());
		ps.setInt(3, userNote.getDelOrNot());
		ps.setString(4, userNote.getNoteTime());
		
		ps.setLong(5, id);
		ps.execute();
	}
	

	/**
	 * 根据ID删除指定笔记
	 */

	public void delete(Connection conn, UserNote userNote) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM user_note WHERE id = ?");
		ps.setLong(1, userNote.getId());
		ps.execute();
	}


	public ResultSet get(Connection conn,  UserNote userNote) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_note WHERE noteName = ?");
		ps.setString(1, userNote.getNoteName());
		return ps.executeQuery();
	}
}