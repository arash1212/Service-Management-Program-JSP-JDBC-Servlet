<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Arash
  Date: 8/31/2021
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>لیست سرویس های فعال</title>
</head>
<body dir="rtl">

<jsp:include page="/templates/headerTemplate.jsp"/>
<br/><br/>

<div>
    <fieldset>
        <legend>لیست سرویس های فعال</legend>
        <be/>
        <br/>
        <table border="1" class="table-responsive table-bordered" style="margin: auto;">
            <tr>
                <th>شماره سرویس</th>
                <th>نام سرویس</th>
                <th>هزینه سرویس</th>
                <th>حداکثر تعداد دفعات استفاده در یک بازه</th>
                <th>تاریخ شروع</th>
                <th>تاریخ پایان</th>
                <th>ساعت شروع</th>
                <th>ساعت پایان</th>
                <th>وضعیت سرویس(فعال/غیرفعال)</th>
            </tr>
            <tr>
                <c:forEach var="service" items="${requestScope.activeServicesList}">
            <tr>
                <form action="/admin/service/save.do" method="get">
                    <td><input type="text" name="id" value="${service.id}" readonly></td>
                    <td><input type="text" name="name" value="${service.name}" readonly></td>
                    <td><input type="text" name="price" value="${service.price}" readonly>
                    <td><input type="text" name="peak" value="${service.peak}" readonly></td>
                    <td><input type="date" value="${service.startDate}" name="startDate" readonly></td>
                    <td><input type="date" value="${service.endDate}" name="endDate" readonly></td>
                    <td><input type="time" value="${service.startTime}" name="startTime" readonly></td>
                    <td><input type="time" value="${service.endTime}" name="endTime" readonly></td>

                    <!-- check if service active or not to check the check box-->
                    <c:if test="${service.active==1}">
                        <td><input type="checkbox" name="active" value="1" checked onclick="return false;"></td>
                    </c:if>

                    <c:if test="${service.active==0}">
                        <td><input type="checkbox" name="active" value="1" onclick="return false;"></td>
                    </c:if>


                </form>
            </tr>
            </c:forEach>
            </tr>
        </table>
    </fieldset>
</div>

</body>
</html>
