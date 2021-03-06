package com.salehi.programming_challenge__1.controller.serviceVaset;

import com.salehi.programming_challenge__1.model.entity.Service;
import com.salehi.programming_challenge__1.model.entity.Service_vaset;
import com.salehi.programming_challenge__1.model.entity.Users;
import com.salehi.programming_challenge__1.model.service.ServiceVasetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/serviceVaset/save.do")
public class Save extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            Users users = new Users().setId(Long.parseLong(request.getParameter("user_id")));
            Service service = new Service().setId(Long.parseLong(request.getParameter("service_id")));

            //
            Service_vaset serviceVaset = ServiceVasetService.getInstance().getOne(new Service_vaset().setService_id(service.getId()).setUser_id(users.getId()));
            //
            if (serviceVaset == null) {
                ServiceVasetService.getInstance().save(users, service);
                response.sendRedirect("/admin/service/findOne.do?id=" + service.getId());
            } else {
                response.sendRedirect("/admin/service/findOne.do?id=" + service.getId());
                throw new Exception("user with this id already registered for this service");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
