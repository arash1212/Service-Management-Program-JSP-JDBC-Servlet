<%--
  Created by IntelliJ IDEA.
  User: Arash
  Date: 8/29/2021
  Time: 6:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>جزییات سرویس</title>
</head>
<body dir="rtl">

<jsp:include page="/templates/headerTemplate.jsp"/>

<fieldset>
    <legend>مشاهده جزییات سرویس</legend>
    <br /><br />
<table border="1" style="margin: auto">
    <tr>
        <th>شماره سرویس</th>
        <th>نام سرویس</th>
        <th>هزینه سرویس</th>
        <th>حداکثر تعداد دفعات استفاده در یک بازه</th>
        <th>تاریخ شروع</th>
        <th>تاریخ پایان</th>
        <th>وضعیت سرویس(فعال/غیرفعال)</th>
        <th>ثبت تغییرات</th>
    </tr>
    <tr>
        <form action="/admin/service/update.do" method="get">
            <td><input type="text" name="id" value="${requestScope.service.id}" readonly></td>
            <td><input type="ti" name="name"  value="${requestScope.service.name}"required></td>
            <td><input type="text" name="price" value="${requestScope.service.price}" required></td>
            <td><input type="text" name="peak" value="${requestScope.service.peak}" required></td>
            <td><input type="datetime-local"  name="startTime" value="${requestScope.service.startDate}" required></td>
            <td><input type="datetime-local" name="endTime" value="${requestScope.service.endDate}" required></td>
            <td><input type="checkbox" name="active" value="${requestScope.service.active}" ></td>
            <td><input type="submit" value="ذخیره تغییرات"></td>
        </form>
    </tr>
</table>
</fieldset>

</body>
</html>
