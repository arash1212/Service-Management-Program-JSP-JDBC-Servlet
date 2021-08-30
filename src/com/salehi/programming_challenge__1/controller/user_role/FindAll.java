package com.salehi.programming_challenge__1.controller.user_role;

import com.salehi.programming_challenge__1.model.entity.User_role;
import com.salehi.programming_challenge__1.model.service.UserRoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/admin/user_role/findAll.do")
public class FindAll extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<User_role> userRoles = UserRoleService.getInstance().findAll();
            request.setAttribute("userRoles", userRoles);
            request.getRequestDispatcher("/admin/RoleManagement.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
