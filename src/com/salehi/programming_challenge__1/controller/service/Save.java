package com.salehi.programming_challenge__1.controller.service;

import com.salehi.programming_challenge__1.model.entity.Service;
import com.salehi.programming_challenge__1.model.service.ServicesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebServlet("/admin/service/save.do")
public class Save extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            if (request.getSession().getAttribute("roleName").toString().equals("admin")) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                //
                Service service = new Service().setName(request.getParameter("name"))
                        .setPrice(Long.parseLong(request.getParameter("price")))
                        .setPeak(Integer.parseInt(request.getParameter("peak")))
                        .setStartDate(String.valueOf(request.getParameter("startDate")))
                        .setEndDate(String.valueOf(request.getParameter("endDate")))
                        .setStartTime(String.valueOf(request.getParameter("startTime")))
                        .setEndTime(String.valueOf(request.getParameter("endTime")))
                        .setActive(request.getParameter("active") == null ? 0 : Short.parseShort(request.getParameter("active")));
                //

                if (!service.getStartDate().equals(service.getEndDate()) && dateFormat.parse(service.getStartDate()).before(dateFormat.parse(service.getEndDate()))) {
                    //
                    ServicesService.getInstance().save(service);
                    //
                } else
                    throw new Exception("service's startDate and endDate should not be the same,and startDate should be before endDate");
                //
                response.sendRedirect("/admin/service/findAll.do");
            } else  response.sendRedirect("/login.jsp");
        }catch(Exception e){
            e.printStackTrace();
            try {
                response.sendRedirect("/admin/ServiceManagment.jsp");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
