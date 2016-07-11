package com.cloudnote.servlet;

import com.cloudnote.entity.UserFile;
import com.cloudnote.util.HibernateUtils;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by user on 2016/6/27.
 */
@WebServlet(name = "delFileServlet" , urlPatterns = "/delFileServlet")
public class delFileServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========删除文件=========");
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        String fileId = req.getParameter("fileId");
        String userId = req.getParameter("userId");
        String fileUrl = req.getParameter("fileUrl");
        System.out.println(req.getParameter(fileUrl));
        File file = new File(fileUrl);

        UserFile userfile = (UserFile) session.createQuery("from UserFile where userId = ? and id = ?").setString(0, userId).setString(1, fileId).uniqueResult();
        session.delete(userfile);
        file.delete();

        // 更新session
        List<UserFile> userFiles = session.createQuery("from UserFile where userId = ?").setParameter(0,Long.parseLong(userId)).list();
        req.getSession().setAttribute("userFiles",userFiles);

        // 跳转
        req.getRequestDispatcher("/main.jsp").forward(req, resp);

        tx.commit();
        session.close();
        System.out.println("=========删除成功=========");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
