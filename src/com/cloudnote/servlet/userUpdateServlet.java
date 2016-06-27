package com.cloudnote.servlet;

import com.cloudnote.entity.User;
import com.cloudnote.impl.userImpl;
import com.cloudnote.util.ConnectionFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by loadi_000 on 2016/6/5.
 */

public class userUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========修改用户开始=========");
        req.setCharacterEncoding("utf-8");
        // 创建User对象
        User user2 = (User) req.getSession().getAttribute("user");
        User user = new User();
        Map<String, String[]> map = req.getParameterMap();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        user.setId(user2.getId());
        user.setPassword(user2.getPassword());
        user.setEmail(user2.getEmail());
        System.out.println("=========封装用户成功=========");
        System.out.println("新用户为"+user);
        java.sql.Connection conn = null;
        conn = ConnectionFactory.getInstance().makeConnection();
        userImpl userl = new userImpl();
        try {
            userl.update(conn, user.getId(), user);
            req.getSession().setAttribute("user",user);
            System.out.println("=========修改用户成功=========");
            req.getRequestDispatcher("/main.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("=========修改用户结束=========");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
