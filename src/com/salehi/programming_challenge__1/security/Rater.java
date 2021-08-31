package com.salehi.programming_challenge__1.security;

import com.salehi.programming_challenge__1.model.entity.User_role;
import com.salehi.programming_challenge__1.model.service.UserRoleService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Rater implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //
        try {
            //
            String requestedURL = request.getRequestURI().split("/")[1];
            String userRoleName = "";
            //
            System.out.println(requestedURL);
            //
            if (request.getSession().getAttribute("roleName") != null) {
                //
                userRoleName = request.getSession().getAttribute("roleName").toString();
                //
                List<User_role> userRoles = UserRoleService.getInstance().getAllByName(userRoleName);
                //
                for (User_role user_role : userRoles) {
                    //
                    System.out.println("role_address :" + user_role.getId());
                    //
                    if (requestedURL.equals(user_role.getAddress())) {
                        System.out.println("access granted");
                        filterChain.doFilter(request, response);
                        return;
                    }
                    //
                }
                //
                System.out.println("role is not allowed in this url");
                response.sendRedirect("/login.jsp");
                //
            } else {
                System.out.println("please login first");
                response.sendRedirect("/login.jsp");
            } ;
            //
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
