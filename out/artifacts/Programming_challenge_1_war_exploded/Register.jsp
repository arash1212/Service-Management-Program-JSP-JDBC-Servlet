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

<fieldset style="margin-right: 5%;">
    <legend>ثبت نام</legend>

    <br />
    <br/>


    <form action="/public/signup.do" >
        <label> نام کاربری <br/>
            <input type="text" name="username" required/> <br /><br />
        </label><br />
        <label> رمز عبور : <br/>
            <input type="password" name="password" required/> <br /><br />
        </label><br />
        <input type="submit" value="ثبت نام" class="btn btn-dark">
    </form>
</fieldset>

</body>
</html>
