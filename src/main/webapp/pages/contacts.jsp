<%--
  Created by IntelliJ IDEA.
  User: lapte
  Date: 05.09.2016
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251"/>
    <title>Contacts</title>
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
            <h1 class="style5">Contacts</h1>
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

            <a href="/usersServlet">
                <span class="style3">Users</span>
            </a>
            <br/>
            <br/>

            <a href="/productGroupsServlet">
                <span class="style3">Product Groups</span>
            </a>
            <br/>
            <br/>

            <span class="style3">Contacts</span>


        </td>

        <td style="width: 80%; height: 541px" valign="top" class="style8">
		<span class="style6">
		    If you have any questions, please contact us!
            <br/>
            web-site: http://localhost:8051/pages/homepage.jsp
            <br/>
            e-mail: laptev.denis@mail.ru
            <br/>
            telephones: 096-571-17-60, 068-593-73-44
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

            <a href="/usersServlet">
                <span class="style6">Users</span>
            </a>
            <span lang="en-us" class="style6"> | </span>

            <a href="/productGroupsServlet">
                <span class="style6">Product Groups</span>
            </a>
            <span lang="en-us" class="style6"> | </span>


            <span class="style6">Contacts</span>

        </td>
    </tr>
</table>

</body>
</html>
