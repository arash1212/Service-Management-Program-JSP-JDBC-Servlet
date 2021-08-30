package com.salehi.programming_challenge__1.controller.users;

import com.salehi.programming_challenge__1.model.entity.User_role;
import com.salehi.programming_challenge__1.model.entity.Users;
import com.salehi.programming_challenge__1.model.service.UserRoleService;
import com.salehi.programming_challenge__1.model.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/public/login.do")
public class Login extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            Users users = UsersService.getInstance().findUserByUsername(new Users().setUsername(request.getParameter("username")));
            if (users != null && users.getPassword().equals(request.getParameter("password"))) {
                User_role user_Role = UserRoleService.getInstance().getOneById(new User_role().setId(users.getRole_id()));
                if (user_Role != null) {
                    request.getSession().setAttribute("roleName", user_Role.getRole_name());
                    response.sendRedirect("/");
                    System.out.println("user logged in");
                } else {
                    response.sendRedirect("/login.jsp");
                    throw new Exception("user role not found");
                }
            } else {
                response.sendRedirect("/login.jsp");
                throw new Exception("user not found / wrong password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
