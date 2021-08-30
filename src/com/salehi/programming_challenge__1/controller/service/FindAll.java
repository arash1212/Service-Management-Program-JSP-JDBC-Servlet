package com.salehi.programming_challenge__1.controller.service;

import com.salehi.programming_challenge__1.model.entity.Service;
import com.salehi.programming_challenge__1.model.service.ServicesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/admin/service/findAll.do")
public class FindAll extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            //
            request.setAttribute("servicesList", ServicesService.getInstance().getAll());
            request.getRequestDispatcher("/admin/Services.jsp").forward(request, response);
            //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
