<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
    request.setAttribute("contextName", request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <p>euye222ee</p>
    <a href="/allBookingList">All Booking List</a>
    <form action="${contextName}/create" method="post">
        <label>Name:<input type="text" name="name" value="" /></label><br/>
        <label>Date:<input type="text" name="date" value="" /></label><br/>
        <label>Price:<input type="text" name="price" value="" /></label><br/>
        <label>Room Type Code:<input type="text" name="roomTypeCode" value="" /></label><br/>
        <button type="submit">Simpan</button>
    </form>
</body>
</html>