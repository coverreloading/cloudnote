package com.cloudnote.impl;

import com.cloudnote.dao.userDao;
import com.cloudnote.entity.User;
import com.cloudnote.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userImpl implements userDao{
	//注册
	public void save(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO user(userName,email, password) values (?, ?, ?)");
		
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.execute();

	}

	/**
	 * id    准备更新的用户的ID
	 * user  新的用户信息
	 * sql:id user_name email password display_pic age sex phone
	 */
//  修改用户信息  可更改内容  用户名 密码 头像 性别 年龄 
	public void update(Connection conn, Long id, User user) throws SQLException {
		String updateSql = "UPDATE user SET userName=? , password = ? ,displayPic = ? ,sex=? ,age=? ,phone=? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(updateSql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ps.setInt(3, user.getDisplayPic());
		ps.setString(4, user.getSex());
		ps.setInt(5, user.getAge());
		ps.setString(6, user.getPhone());
		
		ps.setLong(7, id);
		ps.execute();
	}
	

	/**
	 * 根据用户ID删除指定用户
	 */

	public void delete(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM user WHERE id = ?");
		ps.setLong(1, user.getId());
		ps.execute();
	}

// 结果集
	public ResultSet get(Connection conn,  User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		return ps.executeQuery();
	}
	public static User getByID(String id ) throws SQLException {
		Object[] objs = new Object[] { id };
		String sql = "SELECT * FROM user WHERE id = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class),objs);
	}
}
