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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vincent on 2016/6/23.
 */
@WebServlet(name = "delNoteServlet",urlPatterns = "/delNoteServlet")
public class delNoteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========删除笔记=========");
        org.hibernate.classic.Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
//        UserNote userNote = new UserNote();
        String noteId =req.getParameter("noteId");
        String userId = req.getParameter("userId");
//        int userId = Integer.parseInt(req.getParameter("userId"));
//        userNote = (UserNote) session.get(UserNote.class,userNote.getId());
        UserNote userNote = (UserNote) session.createQuery("from UserNote where userId = ? and id = ?").setString(0, userId).setString(1, noteId).uniqueResult();
        session.delete(userNote);
        // 更新session
        List<UserNote> userNotes=session.createQuery("from UserNote where userId = ?").setParameter(0,Long.parseLong(userId)).list();
        Map<Long, String> userNoteMap = new HashMap<>();
        for (UserNote usernote : userNotes) {
            userNoteMap.put(usernote.getId(),usernote.getNoteName());
        }
        req.getSession().setAttribute("userNoteMap",userNoteMap);
        // 跳转
        req.getRequestDispatcher("/main.jsp").forward(req,resp);
        tx.commit();
        session.close();
        System.out.println("=========删除成功=========");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
