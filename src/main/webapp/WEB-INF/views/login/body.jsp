<%--
  Created by IntelliJ IDEA.
  User: rajesh
  Date: 7/18/19
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
    .error{color:red}
</style>
<div class="container">
<div class="row">
    <div class="col-lg-12">
        <div class="mt-5">
            <div style="text-align: center;" class="card-header">
                <h3>Sign in</h3>
                <p class="error">${errMessage}</p>
            </div>
        </div>
    </div>
</div>
    <div class="row">
        <div class="col-lg-2">
        </div>
        <div class="col-lg-8">
                <form:form method="post" modelAttribute="loginForm">
                    <div class="form-label-group">
                        <label style="" for="inputEmail">Email address</label>

                        <form:input path="email" id="inputEmail" class="form-control" placeholder="Email address"/>
                        <form:errors path="email" cssClass="error"/>
<%--                        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required>--%>

                    </div>
                    <div class="form-label-group">
                        <label style="" for="inputPassword">Password</label>
                        <form:password path="password" id="inputPassword" name="password" class="form-control" placeholder="Password"/>
                        <form:errors path="password" cssClass="error"/>
<%--                        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>--%>

                    </div>

                    <br/>

                    <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Signin</button>
                    <a style=""class="d-block text-left mt-2 small"  href="/signup">Not yet a Member? Sign Up Now!</a>
                    <hr class="my-4">

                </form:form>

            </div>
        </div>
        <div class="col-lg-2">
        </div>
    </div>
</div>
