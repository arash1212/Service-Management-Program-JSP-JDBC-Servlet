package com.salehi.programming_challenge__1.controller.user_role;

import com.salehi.programming_challenge__1.model.entity.User_role;
import com.salehi.programming_challenge__1.model.service.UserRoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/user_role/delete.do")
public class Delete extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            User_role user_role = new User_role()
                    .setId(Long.parseLong(request.getParameter("id")));
            //
            UserRoleService.getInstance().delete(user_role);
            //
            request.getRequestDispatcher("/admin/user_role/findAll.do").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
