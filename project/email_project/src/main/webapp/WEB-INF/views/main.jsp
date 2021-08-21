<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"> </script>
</head>
<body>
    <div class="container">
        <table>
            <tr>
                <th>Company</th>
                <th>Contact</th>
                <th>Country</th>
            </tr>
            <c:forEach var="profile" items="${profileList}">
            <tr>
                <td><c:out value="${profile.id}" /></td>
                <td><c:out value="${profile.username}" /></td>
                <td><c:out value="${profile.remark}" /></td>
            </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>