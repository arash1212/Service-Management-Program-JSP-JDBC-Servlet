<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Arash
  Date: 8/28/2021
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <ul>
        <li><a href="/admin/user_role/findAll.do">مدیریت نقش ها</a></li>
        <li><a href="/admin/ServiceManagment.jsp">مدیریت سرویس ها</a></li>
        <li><a href="/admin/service/findAll.do">مشاهده لیست سرویس ها</a></li>
        <c:if test="${sessionScope.roleName ==null}">
            <li><a href="/Register.jsp">ثبت نام</a></li>
            <li><a href="/login.jsp">ورود به سایت</a></li>
        </c:if>

        <!-- show logged in user's role -->
        <c:if test="${sessionScope.roleName !=null}">
            <c:out value="${sessionScope.roleName}"/>
            <li><a href="/user/logout.do">خروج</a></li>
        </c:if>
    </ul>
</header>

<br/><br/>