package com.cloudnote.impl;

import com.cloudnote.dao.shareNoteDao;
import com.cloudnote.entity.ShareNote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class shareNoteImpl implements shareNoteDao {
	
	//新建分享笔记
	public void save(Connection conn, ShareNote shareNote) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO share_note(shareUrl,shareNoteName,shareTime,userId) values (?, ?, ?,?)");
		ps.setString(1, shareNote.getShareUrl());
		ps.setString(2, shareNote.getShareNoteName());
		ps.setString(3, shareNote.getShareTime());
		ps.setLong(4, shareNote.getUserId());
		ps.execute();
	}

	/**
	 * 根据ID删除指定笔记
	 */
	public void delete(Connection conn, ShareNote shareNote) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM share_note WHERE id = ?");
		ps.setLong(1, shareNote.getId());
		ps.execute();
	}


	public ResultSet get(Connection conn,  ShareNote shareNote) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM share_note WHERE noteName = ?");
		ps.setString(1, shareNote.getShareNoteName());
		return ps.executeQuery();
	}
}