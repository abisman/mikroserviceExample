<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Homepage</title>
</head>
<body>
    <a href="/">Back to index euy</a>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Date</th>
            <th>Price</th>
            <th>Room Type</th>
            <th>Amount of People</th>
        </tr>
        <c:forEach var="books" items="${bookingServices}">
            <tr>
                <td>${books.id}</td>
                <td>${books.name}</td>
                <td>${books.date}</td>
                <td>${books.price}</td>
                <td>${books.roomType}</td>
                <td>${books.personType}</td>
            </tr>
        </c:forEach>
    </table>
    <p>Wadaw</p>
</body>
</html>