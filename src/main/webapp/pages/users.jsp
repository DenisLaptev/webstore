<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lapte
  Date: 23.08.2016
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251"/>
    <title>Users</title>
    <style type="text/css">
        .style2 {
            text-align: center;
            border-style: solid;
            border-width: 1px;
        }

        .style3 {
            font-size: x-large;
        }

        .style5 {
            color: #FF9900;
            text-align: center;
        }

        .style6 {
            font-size: large;
        }

        .style7 {
            border-width: 0px;
        }

        .style8 {
            border-style: solid;
            border-width: 1px;
        }
    </style>
</head>

<body>

<table style="width: 100%" class="style7">
    <tr>
        <td colspan="2" style="height: 70px" class="style8">
            <h1 class="style5">List of Users</h1>
        </td>
    </tr>
    <tr>
        <td style="width: 150px; height: 541px" valign="top" class="style8">
            <a href="/pages/homepage.jsp">
                <span class="style3">Home page</span>
            </a>
            <br/>
            <br/>

            <a href="/pages/login/loginpage.jsp">
                <span class="style3">Login</span>
            </a>
            <br/>
            <br/>

            <a href="/pages/registration/registration.jsp">
                <span class="style3">Registration</span>
            </a>
            <br/>
            <br/>

            <span class="style3">Users</span>
            <br/>
            <br/>

            <a href="/productGroupsServlet">
                <span class="style3">Product Groups</span>
            </a>
            <br/>
            <br/>

            <a href="/pages/contacts.jsp">
                <span class="style3">Contacts</span>
            </a>


        </td>

        <td style="width: 80%; height: 541px" valign="top" class="style8">
		<span class="style6">
		<table style="font:20px 'Times New Roman'" border="1" cellpadding="10" align="center" width="100%" height="200">

            <tr>

                <%--
                Тег <tr> служит контейнером для создания строки таблицы.
                Каждая ячейка в пределах такой строки может задаваться
                с помощью тега <th> или <td>.
                --%>

                <td colspan="2" bgcolor="D0E92B">id</td>
                <td colspan="2" bgcolor="D0E92B">name</td>
                <%--
                     таким образом мы предотвращаем ввод
                     некорректных выражений в текстовое поле
                     если станут вводить html-теги или xml-команды,
                     то они воспримутся как обычный текст
                --%>
                <td colspan="2" bgcolor="D0E92B">secondName</td>
                <td colspan="2" bgcolor="D0E92B">age</td>
                <td colspan="2" bgcolor="D0E92B">email</td>
                <td colspan="2" bgcolor="D0E92B">login</td>
                <td colspan="2" bgcolor="D0E92B">password</td>
                <td colspan="2" bgcolor="D0E92B">role</td>
                <td colspan="2" bgcolor="D0E92B">
                    <%--
                    в данной ячейке также можно удалить пользователя по ссылке.
                    --%>
                    delete user?
                </td>
                <td colspan="2" bgcolor="D0E92B">make admin</td>
            </tr>


            <c:forEach items="${requestScope.users}" var="users">
                <tr>
                    <td colspan="2">${users.id}</td>
                    <td colspan="2"><c:out value="${users.name}"/></td>
                    <td colspan="2"><c:out value="${users.secondName}"/></td>
                    <td colspan="2"><c:out value="${users.age}"/></td>
                    <td colspan="2"><c:out value="${users.email}"/></td>
                    <td colspan="2"><c:out value="${users.login}"/></td>
                    <td colspan="2"><c:out value="${users.password}"/></td>

                    <td colspan="2">user role</td>
                        <%-- <td colspan="2"><c:out value="${users.role}"/></td>--%>

                    <td colspan="2">
                        <a href="deleteUser?id=${users.id}">delete user with id=${users.id}</a>
                    </td>
                    <td colspan="2">
                        <a href="makeAdmin?id=${users.id}">make admin user with id=${users.id}</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
        </span>
        </td>
    </tr>
    <tr>
        <td colspan="2" class="style2" style="height: 50px">

            <a href="/pages/homepage.jsp">
                <span class="style6">Home page</span>
            </a>
            <span lang="en-us" class="style6"> | </span>

            <a href="/pages/login/loginpage.jsp">
                <span class="style6">Login</span>
            </a>
            <span lang="en-us" class="style6"> | </span>

            <a href="/pages/registration/registration.jsp">
                <span class="style6">Registration</span>
            </a>
            <span lang="en-us" class="style6"> | </span>

            <span class="style6">Users</span>
            <span lang="en-us" class="style6"> | </span>

            <a href="/productGroupsServlet">
                <span class="style6">Product Groups</span>
            </a>
            <span lang="en-us" class="style6"> | </span>

            <a href="/pages/contacts.jsp">
                <span class="style6">Contacts</span>
            </a>


        </td>
    </tr>
</table>

</body>


</html>
