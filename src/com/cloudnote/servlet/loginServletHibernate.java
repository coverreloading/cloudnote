
package com.cloudnote.servlet;

import com.cloudnote.entity.User;
import com.cloudnote.entity.UserFile;
import com.cloudnote.entity.UserNote;
import com.cloudnote.impl.userImpl;
import com.cloudnote.util.ConnectionFactory;
import com.cloudnote.util.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by loadi_000 on 2016/6/2.
 */
@WebServlet(name = "loginServletHibernate",urlPatterns = "/loginServletHibernate")
public class loginServletHibernate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========登陆开始=========");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding( "utf-8" );

        org.hibernate.classic.Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        String email =req.getParameter("email");
        String password = req.getParameter("password");

        User user = (User) session.createQuery("from User where email = ? and password = ?").setString(0, email).setString(1,password).uniqueResult();
        System.out.println(user);

        if (!user.equals(null)) {
            List<UserNote> userNotes=session.createQuery("from UserNote u where userId = ? order by u.noteTime desc").setParameter(0,user.getId()).list();
            List<UserFile> userFiles=session.createQuery("from UserFile where userId = ?").setParameter(0,user.getId()).list();


            Map<Long, String> userNoteMap = new LinkedHashMap<>();
            for (UserNote usernote : userNotes) {
                userNoteMap.put(usernote.getId(),usernote.getNoteName());
//                System.out.println(usernote);
            }
//            for(Map.Entry<Long, String> entry:userNoteMap.entrySet()){
//                System.out.println(entry.getKey()+"--->"+entry.getValue());
//            }

            /*Map<Long, String> userFileMap = new LinkedHashMap<>();
            for (UserFile userfile : userFiles) {
                userFileMap.put(userfile.getId(),userfile.getFileName());
            }*/
//            for(Map.Entry<Long, String> entry:map.entrySet()){
//                System.out.println(entry.getKey()+"--->"+entry.getValue());
//            }
            /*if(userNoteMap.equals(null)){
                // 获得session中user
                System.out.println(user.toString());

                // 创建笔记，将从session中获得的id赋值给userNote的userID
                UserNote userNote = new UserNote();
                userNote.setUserId(user.getId());
                userNote.setNoteName("创建新的笔记");
                userNote.setContent("<h1><span style=\"font-family: Impact; color: rgb(0, 0, 0); background-color: rgb(115, 165, 173);\">创建新的笔记</span></h1><h3>修改你的样式</h3><h6>将笔记分享给其他人</h6>");
                // 保存笔记
                session.save(userNote);
            }*/

            req.getSession().setAttribute("user",user);
            req.getSession().setAttribute("userNoteMap",userNoteMap);
            req.getSession().setAttribute("userFiles",userFiles);
            req.getRequestDispatcher("/main.jsp").forward(req, resp);
            System.out.println("=========登陆成功=========");
        }
        if (user.equals(null)) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            System.out.println("=========登陆失败=========");
        }
        System.out.println("=========登陆完毕=========");

        tx.commit();
        session.close();
        return;


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
