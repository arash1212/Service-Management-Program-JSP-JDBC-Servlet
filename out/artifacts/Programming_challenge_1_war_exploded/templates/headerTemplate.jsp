<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Arash
  Date: 8/28/2021
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap/bootstrap.min.css"/>

<body class="text-right" style="background-color:  ">
<header>
    <nav class="navbar navbar-expand-sm bg-dark navbar-light" style="color: white">
        <ul class="nav">
            <li class="nav-item">
                <a style="color: white" class="nav-link active" href="/index.jsp">صفحه اصلی</a>
            </li>

            <li class="nav-item">
                <a style="color: white" class="nav-link" href="/admin/user_role/findAll.do">مدیریت نقش ها</a>
            </li>

            <li class="nav-item">
                <a style="color: white" class="nav-link" href="/admin/ServiceManagment.jsp">افزودن سرویس جدید</a>
            </li>

            <li class="nav-item">
                <a style="color: white" class="nav-link" href="/admin/service/findAll.do">مشاهده لیست سرویس ها</a>
            </li>

            <c:if test="${sessionScope.roleName ==null}">
                    <li class="nav-item">
                        <a style="color: white;" class="nav-link" href="/Register.jsp">ثبت نام</a>
                    </li>
                    <li class="nav-item">
                        <a style="color: white" class="nav-link" href="/login.jsp">ورود به سایت</a>
                    </li>
            </c:if>

            <!-- show logged in user's role -->
            <c:if test="${sessionScope.roleName !=null}">
                <li class="nav-item">
                    <a style="color: white" class="nav-link" href="/user/logout.do">خروج</a>
                </li>

                <c:out value=" نقش کاربر وارد شده : ${sessionScope.roleName} "/>
            </c:if>
        </ul>
    </nav>
</header>
<br/><br/>

</body>

