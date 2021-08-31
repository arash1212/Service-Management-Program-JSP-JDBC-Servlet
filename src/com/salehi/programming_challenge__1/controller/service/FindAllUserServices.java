package com.salehi.programming_challenge__1.controller.service;

import com.salehi.programming_challenge__1.model.service.ServicesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/service/findAllUserServices.do")
public class FindAllUserServices extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            //
            Long userId = Long.parseLong(request.getSession().getAttribute("userId").toString());
            request.setAttribute("userServicesMap", ServicesService.getInstance().getAllUserServices(userId));
            //
            request.getRequestDispatcher("/user/user-services.jsp").forward(request, response);
            //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
