<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251"/>
    <title>Home page</title>
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
            <h1 class="style5">Welcome to the "Lucky Sales" internet shop!</h1>
        </td>
    </tr>
    <tr>
        <td style="width: 150px; height: 541px" valign="top" class="style8">
            <span class="style3">Home page</span>
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

            <a href="/pages/contacts.jsp">
                <span class="style3">Contacts</span>
            </a>


        </td>

        <td style="width: 80%; height: 541px" valign="top" class="style8">
		<span class="style6">
		<img alt="Lucky Sales Logo" src="../pictures/logo.jpg" width="150" height="150"/>
            Welcome to the "Lucky Sales" internet shop!
            <br/>
            You can find everything if you are lucky!
            <br/>
            To browse our products go the <a href="/productGroupsServlet">Product Groups</a> page.
            <br/>
            If you want to buy some products, please first go the <a href="/pages/login/loginpage.jsp">Login Page</a>!
            <br/>
            If you are not registered user, please go to the <a href="/pages/registration/registration.jsp">Registration Page</a>
        </span>
        </td>
    </tr>
    <tr>
        <td colspan="2" class="style2" style="height: 50px">

            <span class="style6">Home page</span>
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

            <a href="/pages/contacts.jsp">
                <span class="style6">Contacts</span>
            </a>


        </td>
    </tr>
</table>

</body>
</html>
