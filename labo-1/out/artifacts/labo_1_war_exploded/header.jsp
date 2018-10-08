<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <h1>
        <span>Web shop</span>
    </h1>
    <nav>
        <ul>
            <li><a href="Controller">Home</a></li>
            <li><a href="Controller?action=overview">Users</a></li>
            <li><a href="Controller?action=products">Products</a></li>
            <li><a href="Controller?action=addProduct">Add product</a></li>
            <li><a href="Controller?action=signUp">Sign up</a></li>
        </ul>
    </nav>
    <h2>${param.title}</h2>

</header>
