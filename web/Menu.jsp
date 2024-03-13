<%-- 
    Document   : Menu
    Created on : Mar 9, 2024, 7:00:16 PM
    Author     : phamt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="home">Book Store</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Category</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="home">All Products</a></li>
                        <li><hr class="dropdown-divider" /></li>
                            <c:forEach items="${category}" var="c">
                            <li><a class="dropdown-item" href="product-to-cate?Cid=${c.getCid()}">${c.getCname()}</a></li>
                            </c:forEach>
                    </ul>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.Account != null}">
                        <c:if test="${sessionScope.Account.isIsAdmin()}">
                            <li class="nav-item"><a class="nav-link" href="loadAccount">Manager Account</a></li>
                            <li class="nav-item"><a class="nav-link" href="aminProuct">Manager Product</a></li>
                            </c:if>
                            <c:if test="${sessionScope.Account.isIsSell()}">
                            <li class="nav-item"><a class="nav-link" href="managerProduct">Manager Product</a></li>
                            </c:if>   
                        <li class="nav-item"><a class="nav-link" >Hello ${sessionScope.Account.getUser()}</a></li>
                        <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>                        
                        </c:when>
                        <c:otherwise>                        
                        <li class="nav-item"><a class="nav-link" href="login">Login</a></li>
                        </c:otherwise>
                    </c:choose>
            </ul>

            <!--form search -->
            <form class="navbar-form navbar-left" action="search" method="post">
                <div class="input-group">
                    <input value="${BookSearch}" name="book" type="text" class="form-control" placeholder="Search">
                    <div class="input-group-append">
                        <button class="btn btn-default" type="submit">
                            <i class="bi bi-search"></i> <!-- Thay đổi icon search tại đây -->
                        </button>
                    </div>
                </div>
            </form>
            <!-- cart  -->
            <form method="post" action="cart" class="d-flex">
                <button class="btn btn-outline-dark" type="submit">
                    <i class="bi-cart-fill me-1"></i>
                    Cart
                    <span class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.carts.size()}</span>
                </button>
            </form>
        </div>
    </div>
</nav>
