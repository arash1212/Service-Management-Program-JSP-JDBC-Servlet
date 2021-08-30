<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Arash
  Date: 8/28/2021
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>مدیریت نقش ها</title>
</head>
<body dir="rtl">

<jsp:include page="/templates/headerTemplate.jsp"/>

<fieldset>
    <form action="/admin/user_role/save.do">
        <label> نام نقش : <br/>
            <input type="text" name="role_name" required/><br/><br/>
        </label>
        <label>آدرس قابل دسترس :</label> <br/>
        <input type="text" name="address" required/><br/><br/>
        </label>
        <input type="submit" name="ثبت نقش">
    </form>
</fieldset>

<br/><br/><br/>

<fieldset>
    <legend>لیست نقش ها :</legend>
    <table border="1" style="margin: auto;width: 100%;">
        <tr>
            <th>شماره نقش</th>
            <th>نام نقش</th>
            <th>آدرس قابل دسترس</th>
            <th>بروزرسانی نقش</th>
            <th>حذف نقش</th>
        </tr>

        <!-- show all user roles in table -->
        <c:forEach var="user_role" items="${requestScope.userRoles}">
            <tr>
                <form action="/admin/user_role/update.do">
                    <td><input type="text" name="id" value="${user_role.id}" readonly/></td>
                    <td><input type="text" name="role_name" value="${user_role.role_name}"/></td>
                    <td><input type="text" name="address" value="${user_role.address}"/></td>
                    <td><input type="submit" value="بروزرسانی"/></td>
                    <td><input type="button" onclick="del(${user_role.id})" value="حذف"/></td>
                </form>
            </tr>
        </c:forEach>
    </table>

</fieldset>

</body>


<script>
    function del(id) {
        window.location = "/admin/user_role/delete.do?id=" + id
    }
</script>
</html>
