<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Product overview"/>
    </jsp:include>
    <main>
        <table>
            <tr>
                <th>Name</th>
                <th>Discription</th>
                <th>Price</th>
            </tr>
            <c:forEach var="product" items="${ productDb.all }">
                <tr>
                    <td>${ product.name }</td>
                    <td>${ product.description }</td>
                    <td>${ product.price }</td>
                </tr>
            </c:forEach>
            <caption>Product Overview</caption>
        </table>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>