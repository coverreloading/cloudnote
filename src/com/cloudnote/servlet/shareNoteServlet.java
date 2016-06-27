package com.cloudnote.servlet;

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
 * Created by Vincent on 2016/6/23.
 */
@WebServlet(name = "shareNoteServlet",urlPatterns = "/shareNoteServlet")
public class shareNoteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========分享笔记=========");
        org.hibernate.classic.Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        String noteId= req.getParameter("noteId");
        String userId= req.getParameter("userId");
        UserNote userNote = (UserNote) session.createQuery("from UserNote where userId = ? and id = ?").setString(0, userId).setString(1, noteId).uniqueResult();
        req.getSession().setAttribute("shareNote",userNote);

        req.getRequestDispatcher("/shareNote.jsp").forward(req,resp);
        tx.commit();
        session.close();
        System.out.println("=========分享结束=========");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
