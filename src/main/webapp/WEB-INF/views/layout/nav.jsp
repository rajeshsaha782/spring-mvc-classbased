    <%@ page import="com.test.social.UserSessionManager" %><%--
  Created by IntelliJ IDEA.
  User: rajesh
  Date: 7/18/19
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
    <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">Blogging</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav">
    <li><a href="#about">About</a>
    </li>
        <%  if (session.getAttribute("user") == null) { %>
    <li><a href="/signup">SignUp</a>
    </li>
    <li><a href="/login">Login</a>
    </li>
        <% } %>

            <%  if (session.getAttribute("user") != null) { %>
    <li><a href="/profile">${email}</a></li>
    <li><a href="/logout">Logout</a></li>
            <% } %>

    </ul>
    </div>
    <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
    </nav>
