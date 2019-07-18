<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="nav" fragment="true" %>


<!doctype html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <jsp:invoke fragment="header"/>
</head>
<body>

<div>
    <jsp:doBody/>
</div>

</body>
</html>

