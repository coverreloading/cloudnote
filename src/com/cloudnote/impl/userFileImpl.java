package com.cloudnote.impl;

import com.cloudnote.dao.userFileDao;
import com.cloudnote.entity.UserFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
*	sql:id file_name file_url del_or_not file_time user_id
 **/
public class userFileImpl implements userFileDao {
	//上传文件
	public void save(Connection conn, UserFile userFile) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO user_file(fileName,content,delOrNot,fileTime) values (?, ?, ?,?)");
		ps.setString(1, userFile.getFileName());
		ps.setString(2, userFile.getContent());
		ps.setInt(3, userFile.getDelOrNot());
		ps.setString(4, userFile.getFileTime());
		ps.execute();

	}

	/**
	 * id    准备更新的笔记的ID
	 * UserNote  新的笔记信息
	 */
//  修改文件  可更改文件名 内容 删除标签 修改时间
	public void update(Connection conn, Long id, UserFile userFile) throws SQLException {
		String updateSql = "UPDATE user_file SET noteName=?, content=?, delOrNot=?, fileTime=? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(updateSql);
		ps.setString(1, userFile.getFileName());
		ps.setString(2, userFile.getContent());
		ps.setInt(3, userFile.getDelOrNot());
		ps.setString(4, userFile.getFileTime());
		
		ps.setLong(5, id);
		ps.execute();
	}
	

	/**
	 * 根据ID删除指定文件
	 */

	public void delete(Connection conn, UserFile userFile) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM user_file WHERE id = ?");
		ps.setLong(1, userFile.getId());
		ps.execute();
	}

//结果集
	public ResultSet get(Connection conn,  UserFile userFile) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_file WHERE noteName = ?");
		ps.setString(1, userFile.getFileName());
		return ps.executeQuery();
	}
}
