package com.cloudnote.impl;

import com.cloudnote.dao.userNotePictureDao;
import com.cloudnote.entity.UserNotePicture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userNotePictureImpl implements userNotePictureDao {
	
	//新建笔记图片
	public void save(Connection conn, UserNotePicture userNotePicture) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO note_picture(userNoteId,picName,picUrl) values (?, ?, ?)");
		ps.setInt(1, userNotePicture.getUserNoteId());
		ps.setString(2, userNotePicture.getPicName());
		ps.setString(3, userNotePicture.getPicUrl());
		ps.execute();
	}
	/**
	 * UserNote  新的笔记图片信息
	 */
//  修改用户信息  可更改内容  笔记名 内容 删除标签 修改时间
	public void update(Connection conn, Long id, UserNotePicture userNotePicture) throws SQLException {
		String updateSql = "UPDATE note_picture SET userNoteId=?, picName=? ,picUrl=?  WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(updateSql);
		ps.setInt(1, userNotePicture.getUserNoteId());
		ps.setString(2, userNotePicture.getPicName());
		ps.setString(3, userNotePicture.getPicUrl());
		ps.setLong(4, id);
		ps.execute();
	}
	

	/**
	 * 根据ID删除指定笔记图片
	 */

	public void delete(Connection conn, UserNotePicture userNotePicture) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM note_picture WHERE id = ?");
		ps.setLong(1, userNotePicture.getId());
		ps.execute();
	}


	public ResultSet get(Connection conn,  UserNotePicture userNotePicture) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM note_picture WHERE id = ?");
		ps.setLong(1, userNotePicture.getId());
		return ps.executeQuery();
	}
}