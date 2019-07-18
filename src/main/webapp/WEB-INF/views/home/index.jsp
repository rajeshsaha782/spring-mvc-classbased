<%--
  Created by IntelliJ IDEA.
  User: rajesh
  Date: 7/18/19
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <jsp:attribute name="header">
        <jsp:include page="../layout/header.jsp"></jsp:include>
    </jsp:attribute>


    <jsp:body>
        <jsp:include page="../layout/nav.jsp"></jsp:include>
        <jsp:include page="body.jsp"></jsp:include>
        <jsp:include page="../layout/footer.jsp"></jsp:include>
    </jsp:body>
</t:wrapper>