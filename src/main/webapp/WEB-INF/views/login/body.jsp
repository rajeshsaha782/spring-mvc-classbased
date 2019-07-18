<%--
  Created by IntelliJ IDEA.
  User: rajesh
  Date: 7/18/19
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
<div class="row">
    <div class="col-4  mx-auto">
        <div class="mx-auto mt-5">
            <div style="color: white; text-align: center;" class="card-header">
                <img class="rounded-circle" height="40" src="{{asset('blog-icon.png')}}" alt=""><strong>logging</strong>
                <h3>Sign in</h3>
            </div>
            <div class="card-body">
                <form method="post"class="form-signin">


                    <div class="form-label-group">
                        <label style="color: white" for="inputEmail">Email address</label>
                        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required>

                    </div>

                    <hr>

                    <div class="form-label-group">
                        <label style="color: white" for="inputPassword">Password</label>
                        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>

                    </div>

                    <br/>

                    <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Signin</button>
                    <a style="color: white"class="d-block text-left mt-2 small"  href="{{route('signup')}}">Not yet a Member? Sign Up Now!</a>
                    <hr class="my-4">

                </form>

            </div>
        </div>
    </div>
</div>
</div>
