package com.cloudnote.servlet;

import com.cloudnote.entity.User;
import com.cloudnote.impl.userImpl;
import com.cloudnote.util.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by loadi_000 on 2016/6/2.
 */

public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========注册开始=========");
        req.setCharacterEncoding("utf-8");
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);
            User user =new User();
            userImpl saveUser = new userImpl();
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));

            if (req.getParameter("user-name")==null){
                user.setUserName(req.getParameter("email"));
                System.out.println("user-name==null");
            }else {
                user.setUserName(req.getParameter("user-name"));
                System.out.println(req.getParameter("user-name"));
            }
            saveUser.save(conn,user);

            conn.commit();
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            System.out.println("=========注册成功=========");
            return;

        } catch (SQLException e) {
            System.out.println("=========失败，开始回滚=========");
            try {
                conn.rollback();
                System.out.println("========回滚成功=========");
            } catch (SQLException e1) {
                e1.printStackTrace();
                System.out.println("=========回滚失败=========");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
