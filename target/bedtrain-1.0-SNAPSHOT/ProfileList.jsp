<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Lista profili</title>
    </head>
    <body>
        <center>
            <h1>Zarządzanie profilami:</h1>
            <h2>
                <a href="/new">Dodaj użytkownika</a>
                <a href="/list">Lista profili</a>
            </h2>
        </center>
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>Lista Profili</h2></caption>
                <tr>
                    <th>ID</th>
                    <th>LOGIN</th>
                    <th>EMAIL</th>
                    <th>IMIĘ</th>
                    <th>NAZWISKO</th>
                    <th>HASŁO</th>
                    <th>IP</th>
                    <th>DATA REJESTRACJI</th>
                    <th>ROLA</th>
                </tr>
                <c:forEach var="profile" items="${profileList}">

                </c:forEach>
            </table>
        </div>
    </body>
</html>