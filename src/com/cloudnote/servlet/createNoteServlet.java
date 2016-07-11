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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Vincent on 2016/6/21.
 */
@WebServlet(name = "createNoteServlet",urlPatterns = "/createNoteServlet")
public class createNoteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========笔记创建=========");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding( "utf-8" );
        org.hibernate.classic.Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 获得session中user
        User user= (User) req.getSession().getAttribute("user");
        System.out.println(user.toString());

        // 创建笔记，将从session中获得的id赋值给userNote的userID
        UserNote userNote = new UserNote();
        userNote.setUserId(user.getId());
        // 当前时间
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(new Date());
        userNote.setNoteName("新笔记"+time);
        long data = new Date().getTime()-1300000000000L + new Random().nextInt(1000);
        userNote.setId(data);
        userNote.setNoteTime(time);
        req.getSession().setAttribute("chooseNote",userNote);
        // 保存笔记
        session.save(userNote);
        // 更新session
        List<UserNote> userNotes=session.createQuery("from UserNote where userId = ?").setParameter(0,user.getId()).list();
        Map<Long, String> userNoteMap = new HashMap<>();
        for (UserNote usernote : userNotes) {
            userNoteMap.put(usernote.getId(),usernote.getNoteName());
        }
        req.getSession().setAttribute("userNoteMap",userNoteMap);

        // 跳转
        req.getRequestDispatcher("/main.jsp").forward(req,resp);
        tx.commit();
        session.close();
        System.out.println("=========新建结束=========");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
