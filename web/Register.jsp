<%--
  Created by IntelliJ IDEA.
  User: Arash
  Date: 8/28/2021
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ثبت نام</title>
</head>
<body dir="rtl">

<jsp:include page="templates/headerTemplate.jsp"/>

<fieldset>
    <legend>ثبت نام</legend>
    <form action="/public/signup.do">
        <label> نام کاربری <br/>
            <input type="text" name="username" required/> <br /><br />
        </label>
        <label> رمز عبور : <br/>
            <input type="password" name="password" required/> <br /><br />
        </label>
        <input type="submit" value="ثبت نام">
    </form>
</fieldset>

</body>
</html>
