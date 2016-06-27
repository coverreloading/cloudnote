
package com.cloudnote.servlet;

        import com.cloudnote.entity.User;
        import com.cloudnote.impl.userImpl;
        import com.cloudnote.util.ConnectionFactory;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.SQLException;

/**
 * Created by loadi_000 on 2016/6/2.
 */
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=========登陆开始=========");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding( "utf-8" );
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            User user = new User();
//            conn.setAutoCommit(false);
            userImpl userResultSet = new userImpl();
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            user.setEmail(email);
            user.setPassword(password);
            System.out.println("email:" + email + "  +  psw:" + password);

            ResultSet rs = userResultSet.get(conn, user);
//            conn.commit();
            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt("id");
                user = userImpl.getByID(String.valueOf(userId));
                System.out.println(user.toString());
            }
            if (userId != 0) {
//                req.setAttribute("user", user);
//                System.out.println("=========cookies UID=========");
//                Cookie c = new Cookie("UID",String.valueOf(userId));
//                resp.addCookie(c);
                req.getSession().setAttribute("user",user);
                req.getRequestDispatcher("/main.jsp").forward(req, resp);
                System.out.println("=========登陆成功=========");
            }
            if (userId == 0) {
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
                System.out.println("=========登陆失败=========");
            }
            System.out.println("=========登陆完毕=========");
            return;

        } catch (SQLException e) {
            System.out.println("=========失败，开始回滚=========");
            try {
                conn.rollback();
                System.out.println("=========回滚成功=========");
            } catch (SQLException e1) {
                e1.printStackTrace();
                System.out.println("=========回滚失败=========");
            }
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
