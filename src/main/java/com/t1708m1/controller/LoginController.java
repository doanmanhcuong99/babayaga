package com.t1708m1.controller;

import com.t1708m1.entity.User;
import com.t1708m1.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie :
                    cookies) {
                System.out.println(cookie.getName() + " - " + cookie.getValue() + " - " + cookie.getDomain());
            }
        }
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentLoggedIn");
        req.setAttribute("user", user);
        req.getRequestDispatcher("/member/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String inputPassword = req.getParameter("password");
        String inputUsername = req.getParameter("username");
        UserModel model = new UserModel();
        User user = model.findByUsernameAndStatus(inputUsername, User.Status.ACTIVE);
        if (user == null) {
            resp.setStatus(404);
            resp.getWriter().println("Tài khoản chưa tồn tại");
        } else {
            if (inputPassword.equals(user.getPassword())) {
                HttpSession session = req.getSession();
                session.setAttribute("currentLoggedIn", user);
                resp.setStatus(200);
                String errorMessage = "Invalid userName or Password";
                req.setAttribute("errorMessage", errorMessage);
                resp.sendRedirect(req.getContextPath() + "/member/listuser");

            } else {
                resp.setStatus(401);
                resp.getWriter().println("Sai thông tin tài khoản hoặc mật khẩu !!! ");
            }
        }


    }
}
