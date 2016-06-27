package com.cloudnote.servlet;

import com.cloudnote.entity.User;
import com.cloudnote.impl.userImpl;
import com.cloudnote.util.ConnectionFactory;
import com.cloudnote.util.HibernateUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "userUpdateServletHibernate",urlPatterns = "/userUpdateServletHibernate")
public class userUpdateServletHibernate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========修改用户开始=========");
        req.setCharacterEncoding("utf-8");

        User user = new User();
        Map<String, String[]> map = req.getParameterMap();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 创建User对象
        User user2 = (User) req.getSession().getAttribute("user");

        user.setId(user2.getId());
        user.setPassword(user2.getPassword());
        user.setEmail(user2.getEmail());
        System.out.println("=========封装用户成功=========");
        System.out.println("新用户为"+user);

        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        session.update(user);
        req.getSession().setAttribute("user",user);
        System.out.println("=========修改用户成功=========");
        req.getRequestDispatcher("/main.jsp").forward(req,resp);

        tx.commit();
        session.close();

        /*java.sql.Connection conn = null;
        conn = ConnectionFactory.getInstance().makeConnection();
        userImpl userl = new userImpl();
        try {
            userl.update(conn, user.getId(), user);
            req.getSession().setAttribute("user",user);
            System.out.println("=========修改用户成功=========");
            req.getRequestDispatcher("/main.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        System.out.println("=========修改用户结束=========");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
