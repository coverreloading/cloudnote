package com.cloudnote.servlet;

import com.cloudnote.entity.User;
import com.cloudnote.entity.UserNote;
import com.cloudnote.util.HibernateUtils;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vincent on 2016/6/21.
 */
@WebServlet(name = "chooseNoteServlet" ,urlPatterns = "/chooseNoteServlet")
public class chooseNoteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========选中笔记=========");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding( "utf-8" );
        org.hibernate.classic.Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 获得session中user
        User user= (User) req.getSession().getAttribute("user");
        System.out.println(user.toString());

        String noteId = req.getParameter("noteId");
        UserNote chooseNote = (UserNote) session.createQuery("from UserNote where id = ?").setString(0, noteId).uniqueResult();
        req.getSession().setAttribute("chooseNote",chooseNote);

        //跳转
        req.getRequestDispatcher("main.jsp").forward(req,resp);

        tx.commit();
        session.close();
        System.out.println("=========返回数据=========");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
