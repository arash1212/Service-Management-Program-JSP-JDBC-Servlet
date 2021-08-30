package com.salehi.programming_challenge__1.controller.serviceVaset;

import com.salehi.programming_challenge__1.model.entity.Service;
import com.salehi.programming_challenge__1.model.entity.Users;
import com.salehi.programming_challenge__1.model.service.ServiceVasetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/serviceVaset/deleteUserFromService.do")
public class RemoveUserFromService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            Users users = new Users().setId(Long.parseLong(request.getParameter("user_id")));
            Service service = new Service().setId(Long.parseLong(request.getParameter("service_id")));
            System.out.println(users.getId() + " " + service.getId());
            ServiceVasetService.getInstance().deleteUserFromService(users, service);
            response.sendRedirect("/admin/service/findOne.do?id=" + service.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
