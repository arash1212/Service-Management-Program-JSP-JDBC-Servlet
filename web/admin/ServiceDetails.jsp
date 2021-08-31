<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div>

    <div class="container">
        <fieldset>
            <legend class="w-auto">افزودن کاربر به سرویس</legend>

            <table border="1" class="table" style="margin: auto">
                <tr>
                    <th>شماره سرویس</th>
                    <th>آی دی کاربر مورد نظر</th>
                    <th>نام کاربری مورد نظر</th>
                    <th>افزودن کاربر به سرویس</th>
                </tr>

                <tr>
                    <form action="/admin/serviceVaset/save.do">
                        <td><input type="text" name="service_id" value="${param.id}" required readonly/></td>
                        <td><input type="text" name="user_id" required/></td>
                        <td><input type="text" name="username" required/></td>
                        <td><input type="submit" value="افزودن کاربر" class="btn btn-dark"></td>
                    </form>
                </tr>

            </table>

        </fieldset>

    </div>


    <br/><br/>
    <hr />
    <br/><br/>

    <fieldset>
        <legend>مشاهده جزییات سرویس</legend>

        <br/><br/>
        <table border="1" class="table table-responsive" style="margin: auto">
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
                <th>ثبت تغییرات</th>
            </tr>
            <tr>
                <form action="/admin/service/update.do" method="get">

                    <td><input type="text" name="id" value="${requestScope.service.id}" readonly></td>
                    <td><input type="text" name="name" value="${requestScope.service.name}" required></td>
                    <td><input type="text" name="price" value="${requestScope.service.price}" required></td>
                    <td><input type="text" name="peak" value="${requestScope.service.peak}" required></td>
                    <td><input type="date" name="startDate" value="${requestScope.service.startDate}" required></td>
                    <td><input type="date" name="endDate" value="${requestScope.service.endDate}" required></td>
                    <td><input type="time" name="startTime" value="${requestScope.service.startTime}" required></td>
                    <td><input type="time" name="endTime" value="${requestScope.service.endTime}" required></td>

                    <!-- check if service active or not to check the check box-->
                    <c:if test="${requestScope.service.active==1}">
                        <td><input type="checkbox" name="active" value="1" checked></td>
                    </c:if>

                    <c:if test="${requestScope.service.active==0}">
                        <td><input type="checkbox" name="active" value="1"></td>
                    </c:if>

                    <td><input type="submit" value="ذخیره تغییرات" class="btn btn-dark"></td>
                </form>
            </tr>
        </table>
    </fieldset>

    <br/><br/>
    <hr />
    <br/><br/>

    <div class="container">
        <fieldset>
            <legend>لیست اعضا</legend>

            <h4>تعداد اعضا سرویس : <c:out value="${requestScope.servicesList.size()}"/></h4>

            <table class="table" border="1">
                <tr>
                    <th>آی دی</th>
                    <th>نام کاربری</th>
                    <th>اعتبار</th>
                    <th>ای دی نقش</th>
                    <th>حذف کاربر از سرویس</th>
                </tr>
                <c:forEach var="user" items="${requestScope.serviceUsersList}">
                    <tr>
                        <form action="/admin/serviceVaset/deleteUserFromService.do">
                            <input type="text" name="service_id" value="${param.id}" readonly hidden>
                            <td><input type="text" name="user_id" value="${user.id}" readonly/></td>
                            <td><input type="text" name="username" value="${user.username}" readonly/></td>
                            <td><input type="text" name="credit" value="${user.credit}" readonly/></td>
                            <td><input type="text" name="role_id" value="${user.role_id}" readonly/></td>
                            <td><input type="submit" value="حذف از سرویس" class="btn btn-dark"/></td>
                        </form>
                    </tr>
                </c:forEach>
            </table>

        </fieldset>
    </div>

    <br/><br/>
</div>

</body>
</html>
