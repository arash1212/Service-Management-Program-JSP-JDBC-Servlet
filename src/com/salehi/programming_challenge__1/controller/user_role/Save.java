package com.salehi.programming_challenge__1.controller.user_role;

import com.salehi.programming_challenge__1.model.entity.User_role;
import com.salehi.programming_challenge__1.model.service.UserRoleService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet("/admin/user_role/save.do")
public class Save extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        try {
            User_role user_role = new User_role().setRole_name(request.getParameter("role_name"))
                    .setAddress(request.getParameter("address"));
            //
            UserRoleService.getInstance().save(user_role);
            //
            request.getRequestDispatcher("/admin/user_role/findAll.do").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
