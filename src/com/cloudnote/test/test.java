package com.cloudnote.test;

import com.cloudnote.entity.User;
import com.cloudnote.entity.UserFile;
import com.cloudnote.entity.UserNote;
import com.cloudnote.util.HibernateUtils;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.*;

/**
 * Created by Vincent on 2016/6/17.
 */
public class test {
    @Test
    // 向数据库中插入一条记录
    public void demo1() {
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
        user.setUserName("111");
        user.setPassword("1");
        user.setEmail("1@1.com");

        session.save(user);

        // 6.事务提交
        tx.commit();
        // 7.释放资源
        session.close();
        sessionFactory.close();
    }

    @Test
    public void deo2() {
        org.hibernate.classic.Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        String email = "1@1.com";
        String password = "1";

        User user = new User();
        user = (User) session.createQuery("from User where email = ? and password = ?").setString(0, email).setString(1, password).uniqueResult();
        System.out.println(user);

       /* List<User> list = session.createQuery("from User").list();
         for (User customer : list) {
          		System.out.println(customer);
          	}
*/
        tx.commit();
        session.close();

    }

    @Test
    public void demo3() {
        org.hibernate.classic.Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        UserFile userfile = new UserFile();

        userfile.setFileName("123");
        userfile.setFileUrl("321");



        session.save(userfile);


        tx.commit();
        session.close();
    }

    @Test
    public void demo6() {
        org.hibernate.classic.Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        UserFile userFile = new UserFile();
        userFile.setFileName("测试2");
        userFile.setContent("23333333");
        userFile.setFileUrl("aaa");
        session.save(userFile);


        tx.commit();
        session.close();
    }

    @Test
    public void demo4() {
        org.hibernate.classic.Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        /*User user = (User) session.createQuery("from User where email = ?").setParameter(0,"1@1.com").uniqueResult();
        System.out.println(user);*/

        User user = (User) session.createQuery("from User where id = ?").setParameter(0, (long) 20).uniqueResult();
        System.out.println(user);

        tx.commit();
        session.close();
    }

    @Test
    public void demo5() {
        org.hibernate.classic.Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        List<UserNote> userNotes = session.createQuery("from UserNote ").list();
        Map<Long, String> map = new HashMap<>();
        for (UserNote usernote : userNotes) {
            map.put(usernote.getId(),usernote.getNoteName());
        }
        for(Map.Entry<Long, String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }

        tx.commit();
        session.close();
    }
    // del note
    @Test
    public void demo7(){
        org.hibernate.classic.Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

//        UserNote userNote = new UserNote();
//        userNote.setId((long) 47);
//        userNote = (UserNote) session.get(UserNote.class,userNote.getId());
//        session.delete(userNote);


        int noteId =48;
        int userId = 20;
//        int userId = Integer.parseInt(req.getParameter("userId"));
//        userNote = (UserNote) session.get(UserNote.class,userNote.getId());
        UserNote userNote = (UserNote) session.createQuery("from UserNote where userId = ? and id = ?").setString(0, String.valueOf(userId)).setString(1, String.valueOf(noteId)).uniqueResult();
        session.delete(userNote);

        tx.commit();
        session.close();
    }
    // 随机数
    @Test
    public void demo8(){
//        UUID uuid = UUID.randomUUID();
//        System.out.println(uuid);
//        Calendar calendar = Calendar.getInstance();
//        int  data = (int) (new Date().getTime()-1300000000L + new Random().nextInt(10000));
//        System.out.println("现在："+data+"     "+calendar.getTime().getTime());

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
        user.setPassword("123");
        user.setEmail("123");
        session.save(user);


        // 6.事务提交
        tx.commit();
        // 7.释放资源
        session.close();
        sessionFactory.close();


    }
}
