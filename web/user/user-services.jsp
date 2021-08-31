<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Arash
  Date: 8/31/2021
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>مشاهده سرویس های کاربر</title>
</head>
<body dir="rtl">

<jsp:include page="/templates/headerTemplate.jsp"/>
<br/><br/>

<div>
    <fieldset>
        <legend>لیست سرویس های کاربر</legend>
        <be/>
        <br/>
        <table border="1" class="table-responsive" style="margin: auto;">
            <tr>
                <th>شماره سرویس</th>
                <th>نام سرویس</th>
                <th>هزینه سرویس</th>
                <th>حداکثر تعداد دفعات استفاده در یک بازه</th>
                <th>میزان استفاده کاربر از سرویس</th>
                <th>تاریخ شروع</th>
                <th>تاریخ پایان</th>
                <th>ساعت شروع</th>
                <th>ساعت پایان</th>
                <th>وضعیت سرویس(فعال/غیرفعال)</th>
            </tr>
                <c:forEach var="service" items="${requestScope.userServicesMap}">
            <tr>
                <form action="/admin/service/save.do" method="get">
                    <td><input type="text" name="id" value="${service.key.id}" readonly/></td>
                    <td><input type="text" name="name" value="${service.key.name}" readonly/></td>
                    <td><input type="text" name="price" value="${service.key.price}" readonly/>
                    <td><input type="text" name="peak" value="${service.key.peak}" readonly/></td>
                    <td><input type="text" name="peak" value="${service.value.useTime}" readonly/></td>
                    <td><input type="date" value="${service.key.startDate}" readonly/></td>
                    <td><input type="date" value="${service.key.endDate}" readonly/></td>
                    <td><input type="time" value="${service.key.startTime}" readonly/></td>
                    <td><input type="time" value="${service.key.endTime}" readonly/></td>

                    <!-- check if service active or not to check the check box-->
                    <c:if test="${service.key.active==1}">
                        <td><input type="checkbox" name="active" value="1" checked onclick="return false;"></td>
                    </c:if>

                    <c:if test="${service.key.active==0}">
                        <td><input type="checkbox" name="active" value="1" onclick="return false;"></td>
                    </c:if>

                </form>
            </tr>

            </c:forEach>

        </table>
    </fieldset>
</div>


</body>
</html>
