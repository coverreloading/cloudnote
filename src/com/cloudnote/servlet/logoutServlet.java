package com.cloudnote.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public logoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("=========注销开始=========");
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		session.removeAttribute("userNoteMap");
		session.removeAttribute("userFileMap");
		session.removeAttribute("chooseNote");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		System.out.println("=========注销成功=========");
		return;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
