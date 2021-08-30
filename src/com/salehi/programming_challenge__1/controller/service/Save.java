package com.salehi.programming_challenge__1.controller.service;

import com.salehi.programming_challenge__1.model.entity.Service;
import com.salehi.programming_challenge__1.model.service.ServicesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/admin/service/save.do")
public class Save extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            //
            Service service = new Service().setName(request.getParameter("name"))
                    .setPrice(Long.parseLong(request.getParameter("price")))
                    .setPeak(Integer.parseInt(request.getParameter("peak")))
                    .setStartDate(String.valueOf(request.getParameter("startTime")))
                    .setEndDate(String.valueOf(request.getParameter("endTime")))
                    .setActive(Boolean.parseBoolean(request.getParameter("active")));
            //
            System.out.println(service.getStartDate());
            if (!service.getStartDate().equals(service.getEndDate()) && dateFormat.parse(service.getStartDate()).before(dateFormat.parse(service.getEndDate()))) {
                ServicesService.getInstance().save(service);
            } else
                throw new Exception("service's startDate and endDate should not be the same,and startDate should be before endDate");
            //
            response.sendRedirect("/admin/service/findAll.do");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
