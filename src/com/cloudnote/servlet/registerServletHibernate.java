package com.cloudnote.servlet;

import com.cloudnote.entity.User;
import com.cloudnote.impl.userImpl;
import com.cloudnote.util.ConnectionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by loadi_000 on 2016/6/2.
 */
@WebServlet(name = "registerServletHibernate",urlPatterns = "/registerServletHibernate")
public class registerServletHibernate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("=========注册开始=========");
        req.setCharacterEncoding("utf-8");

        // 1.Hiberante框架加载核心配置文件(有数据库连接信息)
        Configuration configuration = new Configuration().configure();
        // 2.创建一个SessionFactory.(获得Session--相当连接对象)
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3.获得Session对象.
        Session session = sessionFactory.openSession();
        // 4.默认的情况下,事务是不自动提交.
        Transaction tx = session.beginTransaction();
        // 5.业务逻辑操作

        // 向数据库中插入一条记录:
        User user = new User();
        long data =  new Date().getTime()-1300000000000L + new Random().nextInt(1000);
        user.setId(data);
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));

        if (req.getParameter("user-name").equals(null)) {
            user.setUserName(req.getParameter("email"));
            System.out.println("user-name==null");
        } else {
            user.setUserName(req.getParameter("user-name"));
            System.out.println(req.getParameter("user-name"));
        }
        session.save(user);
        req.getRequestDispatcher("/login.jsp").forward(req, resp);


        // 6.事务提交
        tx.commit();
        // 7.释放资源
        session.close();
        sessionFactory.close();
        System.out.println("=========注册成功=========");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
