<%--
  Created by IntelliJ IDEA.
  User: Arash
  Date: 8/29/2021
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>مدیریت سرویس ها</title>
</head>

<body dir="rtl">

<jsp:include page="/templates/headerTemplate.jsp"/>


<div class="container-fluid">
<fieldset>
    <legend>افزودن سرویس جدید</legend>
    <br/><br/>
    <table border="1" style="margin: auto" class="table">
        <tr>
            <%--        <th>شماره سرویس</th>--%>
            <th>نام سرویس</th>
            <th>هزینه سرویس</th>
            <th>حداکثر تعداد دفعات استفاده در یک بازه</th>
            <th>تاریخ شروع</th>
            <th>تاریخ پایان</th>
            <th>ساعت شروع</th>
            <th>ساعت پایان</th>
            <th>وضعیت سرویس(فعال/غیرفعال)</th>
            <th>ثبت سرویس</th>
        </tr>
        <tr>
            <form action="/admin/service/save.do" method="get">
                <%--            <td><input type="text" name="id"></td>--%>
                <td><input type="ti" name="name" required></td>
                <td><input type="text" name="price" required></td>
                <td><input type="text" name="peak" required></td>
                <td><input type="date" name="startDate" required></td>
                <td><input type="date" name="endDate" required></td>
                <td><input type="time" name="startTime" required></td>
                <td><input type="time" name="endTime" required></td>
                <td><input type="checkbox" name="active" value="1"></td>
                <td><input type="submit" value="ثبت" class="btn btn-dark"></td>
            </form>
        </tr>
    </table>
</fieldset>
</div>
</body>
</html>
