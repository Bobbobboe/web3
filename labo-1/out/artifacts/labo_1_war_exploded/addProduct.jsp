<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Sign Up"/>
    </jsp:include>
    <body>
    <c:if test="${not empty errors}">

    <main>
        <div class="alert-danger">
            <c:forEach var="error" items="${errors}">
                <ul>
                    <li>${error}</li>
                </ul>
            </c:forEach>
        </div>
        </c:if>


        <form method="post" action="Controller?action=submitProduct" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->
            <p><label for="name">Name</label><input type="text" id="name" name="name"
                                                         required value="${name}"></p>
            <p><label for="description">Description</label><input type="text" id="description" name="description"
                                                               required value="${description}"></p>
            <p><label for="price">Price</label><input type="number" id="price" name="price"
                                                             required value="${price}"></p>
            <p><input type="submit" id="signUp" value="add"></p>

        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
