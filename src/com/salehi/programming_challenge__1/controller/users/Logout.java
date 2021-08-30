package com.salehi.programming_challenge__1.controller.users;

import org.apache.catalina.Server;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/logout.do")
public class Logout extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        try {
            request.getSession().removeAttribute("roleName");
            System.out.println("user logged out");
            response.sendRedirect("/");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("error in user logout");
        }
    }
}
