package com.cloudnote.jdbc;

import com.cloudnote.dao.userDao;
import com.cloudnote.entity.User;
import com.cloudnote.impl.userImpl;
import com.cloudnote.util.ConnectionFactory;
import org.junit.Test;

import java.sql.*;

public class TransactionTest {
	public static Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudnote", "root", "root");
		}catch (Exception e){
			e.printStackTrace();
		}
		return conn;
	}

	public static void insertUserData(){
		Connection conn = getConnection();
		try {
			String sql = "insert into user(user_name,email,password,age,sex,phone)" + "values('黄培生','Hxiaope@163.com','123456',23,'女','13549784255')";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("向用户插入了" + count + "条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public static void insertUAddressData(){
		Connection conn = getConnection();
		try {
			String sql = "insert into tbl_address(id,name,password,email)" + "values(1,'shanghai','china','10')";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("向地址表插入了" + count + "条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	@Test
	public void test(){
		System.out.println("========登陆=========");
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			User user =new User();
//            conn.setAutoCommit(false);
			userImpl userResultSet = new userImpl();
//            user.setEmail(req.getParameter("email"));
//            user.setPassword(req.getParameter("password"));
			user.setEmail("1@1.com");
			user.setPassword("1");
			user.setUserName("1");
//            System.out.println(req.getParameter("email")+"+"+req.getParameter("password"));

			ResultSet rs = userResultSet.get(conn,user);
//            conn.commit();

			if(rs.next()){
				System.out.println(rs);
				System.out.println(rs.getInt("id"));
			}



//			rs.getInt("display_pic");
			System.out.println("email:");

//            req.getRequestDispatcher("/main.jsp").forward(req, resp);
			System.out.println("========登陆完毕=========");
			return;

		} catch (SQLException e) {
			System.out.println("========失败，开始回滚=========");
			try {
				conn.rollback();
				System.out.println("========回滚成功=========");
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("========回滚失败=========");
			}
		}
	}

	@Test
	public  void listtest(){

		String i= "1";
		userImpl u = new userImpl();
		try {
			User user = u.getByID(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		//insertUserData();
		//System.out.println("insert into user(user_name,email,password,age,sex,phone)" + "values('黄培生','Hxiaope@163.com','123456',23,'女','13549784255')");
		userDao d = new userImpl();
		User u = new User();
		Connection conn = null;
		conn = ConnectionFactory.getInstance().makeConnection();
		u.setUserName("中asd");
		u.setEmail("asdasd");
		u.setPassword("asdad");
//		u.setAge(10);
//		u.setDisplayPic(1);
//		u.setPhone("1213313");
//		u.setSex("nan");
		System.out.println("11111111");
		try {
			System.out.println(u.getUserName());
			d.save(conn, u);
			System.out.println("22222");
		}catch (Exception e){
			e.printStackTrace();
		}

		//insertUAddressData();
	}
}
