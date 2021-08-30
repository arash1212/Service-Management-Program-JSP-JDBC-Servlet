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

@WebServlet("/public/signup.do")
public class Signup extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            User_role user_role = UserRoleService.getInstance().getOneByName(new User_role().setRole_name("user"));
            if (user_role != null) {
                if (UsersService.getInstance().findUserByUsername(new Users().setUsername(request.getParameter("username"))) == null) {
                    //
                    Users users = new Users()
                            .setUsername(request.getParameter("username"))
                            .setPassword(request.getParameter("password"))
                            .setRole_id(user_role.getId())
                            .setCredit(0L);
                    //
                    UsersService.getInstance().save(users);
                    response.sendRedirect("/");
                }else{
                    response.sendRedirect("/error/error-duplicate-username.jsp");
                    throw new Exception("username already exists");
                }
            } else throw new Exception("No user role found");
            //

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
