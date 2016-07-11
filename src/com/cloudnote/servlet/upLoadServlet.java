package com.cloudnote.servlet;

import com.cloudnote.entity.User;
import com.cloudnote.entity.UserFile;
import com.cloudnote.util.HibernateUtils;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Vincent on 2016/6/21.
 */
@MultipartConfig
@WebServlet(name = "upLoadServlet", urlPatterns = "/upLoadServlet")
public class upLoadServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========文件上传=========");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        org.hibernate.classic.Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 获得session中user
        User user = (User) req.getSession().getAttribute("user");
        System.out.println(user.toString());

        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = this.getServletContext().getRealPath("/WEB-INF/upLoadFiles");
        System.out.println("savepath"+savePath);
        File file = new File(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists()) {
            System.out.println(savePath + "目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }

        // 创建file，将从session中获得的id赋值给userFile的userID
        UserFile userFile = new UserFile();
        userFile.setUserId(user.getId());
        // 当前时间
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(new Date());
        userFile.setFileTime(time);

        Part part = req.getPart("file");

        //获得原文件名
        String header = part.getHeader("Content-Disposition");
        String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
        System.out.println(fileName);
        userFile.setFileName(fileName);


        //上传文件
        part.write(savePath + "/" + fileName);

        //更新数据库
        userFile.setFileUrl(savePath + "/" + fileName );
        System.out.println("url地址" + savePath + "/" + fileName);
        req.getSession().setAttribute("chooseFile", userFile);
        session.save(userFile);
        // 更新session
        List<UserFile> userFiles = session.createQuery("from UserFile where userId = ?").setParameter(0, user.getId()).list();
        System.out.println(userFiles);
        /*Map<Long, String> userFileMap = new LinkedHashMap<>();
        for (UserFile userFile2 : userFiles) {
            userFileMap.put(userFile2.getId(), userFile2.getFileName());
        }*/

        /*for(Map.Entry<Long, String> entry:userFileMap.entrySet()){
                System.out.println(entry.getKey()+"--->"+entry.getValue());
            }*/
        req.getSession().setAttribute("userFiles",userFiles);

        // 跳转
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
        tx.commit();
        session.close();
        System.out.println("=========上传结束=========");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
