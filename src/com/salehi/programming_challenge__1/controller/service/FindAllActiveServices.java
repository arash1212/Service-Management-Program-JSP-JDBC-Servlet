package com.salehi.programming_challenge__1.controller.service;

import com.salehi.programming_challenge__1.model.service.ServicesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebServlet("/service/findAllActiveServices.do")
public class FindAllActiveServices extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            //
            request.setAttribute("activeServicesList", ServicesService.getInstance().getAllActiveServices());
            request.getRequestDispatcher("/user/active-services.jsp").forward(request, response);
            //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
