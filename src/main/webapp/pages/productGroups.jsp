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
    <title>Product Groups</title>
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
            <h1 class="style5">List of Product Groups</h1>
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

            <span class="style3">Product Groups</span>
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
                <td colspan="2" bgcolor="D0E92B">shortName</td>
                <%--
                     таким образом мы предотвращаем ввод
                     некорректных выражений в текстовое поле
                     если станут вводить html-теги или xml-команды,
                     то они воспримутся как обычный текст
                --%>
                <td colspan="2" bgcolor="D0E92B">description</td>

                <td colspan="2" bgcolor="D0E92B">
                    <%--
                    в данной ячейке также можно удалить пост по ссылке.
                    Но эта ссылка не в виде рисунка, а в виде текста.
                    --%>
                    delete product group?</a>
                </td>
            </tr>


            <c:forEach items="${requestScope.productGroups}" var="productgroups">
                <tr>
                    <td colspan="2">${productgroups.id}</td>
                    <td colspan="2"><a href="/products"><c:out value="${productgroups.shortName}"/></a></td>
                    <td colspan="2"><c:out value="${productgroups.description}"/></td>
                    <td colspan="2">
                        <a href="deleteProductGroup?id=${productgroups.id}">delete product group with id=${productgroups.id}</a>
                    </td>
                </tr>
            </c:forEach>

            <form action="/addProductGroup" method="post">
                <%--
                    <form>
                    form это компонент, позволяющий пользователю воодить данные
                    с помощью input

                    Тег <form> устанавливает форму на веб-странице.
                    Форма предназначена для обмена данными между
                    пользователем и сервером.

                    Когда форма отправляется на сервер, управление данными
                    передается программе, заданной атрибутом action тега <form>.
                    Предварительно браузер подготавливает информацию в виде
                    пары «имя=значение», где имя определяется атрибутом
                    name тега <input>, а значение введено пользователем или
                    установлено в поле формы по умолчанию.

                    action - Адрес программы или документа,
                             который обрабатывает данные формы.

                    method - Метод протокола HTTP.

                    Значение атрибута method не зависит от регистра.
                    Различают два метода — get и post.

                    get
                    Этот метод является одним из самых распространенных
                    и предназначен для получения требуемой информации
                    и передачи данных в адресной строке.
                    Пары «имя=значение» присоединяются в этом случае к адресу
                    после вопросительного знака
                    и разделяются между собой амперсандом (символ &).
                    Удобство использования метода get заключается в том,
                    что адрес со всеми параметрами можно использовать неоднократно,
                    сохранив его, например, в закладки браузера,
                    а также менять значения параметров прямо в адресной строке.

                    post
                    Метод post посылает на сервер данные в запросе браузера.
                    Это позволяет отправлять большее количество данных,
                    чем доступно методу get, поскольку у него установлено ограничение
                    в 4 Кб. Большие объемы данных используются в форумах,
                    почтовых службах, заполнении базы данных,
                    при пересылке файлов и др.

                --%>
                <tr>
                    <td colspan="2">
                        id (autoincrement)

                        <%--
                         <input>
                         Тег <input> является одним из разносторонних элементов формы
                         и позволяет создавать разные элементы интерфейса и обеспечить
                         взаимодействие с пользователем. Главным образом <input>
                         предназначен для создания текстовых полей, различных кнопок,
                         переключателей и флажков. Хотя элемент <input> не требуется
                         помещать внутрь контейнера <form>, определяющего форму,
                         но если введенные пользователем данные должны быть отправлены
                         на сервер, где их обрабатывает серверная программа,
                         то указывать <form> обязательно. То же самое обстоит
                         и в случае обработки данных с помощью клиентских приложений,
                         например, скриптов на языке JavaScript.

                        Основной атрибут тега <input>, определяющий вид элемента — type.
                        Он позволяет задавать следующие элементы формы:
                        текстовое поле (text), поле с паролем (password),
                        переключатель (radio), флажок (checkbox), скрытое поле (hidden),
                        кнопка (button), кнопка для отправки формы (submit),
                        кнопка для очистки формы (reset),
                        поле для отправки файла (file) и кнопка с изображением (image).
                        Для каждого элемента существует свой список атрибутов,
                        которые определяют его вид и характеристики.
                        Кроме того, в HTML5 добавлено еще более десятка новых элементов.


                        атрибуты <input>

                        name
                        Имя поля, предназначено для того, чтобы обработчик формы
                        мог его идентифицировать.

                        type
                        тип элемента (
                        текстовое поле (text),
                        поле с паролем (password),
                        переключатель (radio),
                        флажок (checkbox),
                        скрытое поле (hidden),
                        кнопка (button),
                        кнопка для отправки формы (submit),
                        кнопка для очистки формы (reset),
                        поле для отправки файла (file)
                        кнопка с изображением (image)
                        и т.д.)

                        --%>

                    </td>
                    <td colspan="2">
                        <input name='PGshortName' type="text" style="font:20px 'Times New Roman'">
                    </td>
                    <td colspan="2">
                        <input name='PGdescription' type="text" style="font:20px 'Times New Roman'">
                    </td>

                    <td>
                        <input type="submit" style="font:20px 'Times New Roman'">
                    </td>
                </tr>
            </form>
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

            <a href="/usersServlet">
                <span class="style6">Users</span>
            </a>
            <span lang="en-us" class="style6"> | </span>

            <span class="style6">Product Groups</span>
            <span lang="en-us" class="style6"> | </span>

            <a href="/pages/contacts.jsp">
                <span class="style6">Contacts</span>
            </a>


        </td>
    </tr>
</table>

</body>


</html>
