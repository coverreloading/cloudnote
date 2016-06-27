package com.cloudnote.servlet;

import com.cloudnote.entity.User;
import com.cloudnote.entity.UserFile;
import com.cloudnote.entity.UserNote;
import com.cloudnote.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

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
 * Created by Vincent on 2016/6/22.
 */
@WebServlet(name = "updateNoteServlet",urlPatterns = "/updateNoteServlet")
public class updateNoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========笔记更新=========");
        req.setCharacterEncoding("utf-8");
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        String noteName= req.getParameter("noteName");
        String noteContent= req.getParameter("noteContent");
        UserNote chooseNote = (UserNote) req.getSession().getAttribute("chooseNote");
        String noteId = String.valueOf(chooseNote.getId());
        User user = (User)req.getSession().getAttribute("user");
        long userId= user.getId();

        UserNote userNote = (UserNote) session.createQuery("from UserNote where id = ?").setString(0, noteId).uniqueResult();
        userNote.setNoteName(noteName);
        userNote.setContent(noteContent);
        session.update(userNote);

        List<UserNote> userNotes=session.createQuery("from UserNote where userId = ?").setParameter(0,userId).list();
        Map<Long, String> userNoteMap = new HashMap<>();
        for (UserNote usernote : userNotes) {
            userNoteMap.put(usernote.getId(),usernote.getNoteName());
        }
        req.getSession().setAttribute("chooseNote",userNote);
        req.getSession().setAttribute("userNoteMap",userNoteMap);
        req.getRequestDispatcher("/note.jsp").forward(req,resp);

        tx.commit();
        session.close();
        System.out.println("=========更新完成=========");

//        System.out.println(req.getParameter("i"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
