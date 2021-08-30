package com.salehi.programming_challenge__1.controller.service;

import com.salehi.programming_challenge__1.model.entity.Service;
import com.salehi.programming_challenge__1.model.service.ServicesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/service/findOne.do")
public class FindOne extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            Service service = ServicesService.getInstance().getOne(new Service().setId(Long.parseLong(request.getParameter("id"))));
            //
            if (service != null) {
                request.setAttribute("service", service);
                request.setAttribute("serviceUsersList", ServicesService.getInstance().getAllServiceUsers(service));
                //
                request.getRequestDispatcher("/admin/ServiceDetails.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/admin/service/findAll.do").forward(request, response);
                throw new Exception("Service not found exception");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
