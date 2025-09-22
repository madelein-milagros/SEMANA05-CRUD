<%@ page import="com.tecsup.semana05crud.model.entities.Administrador" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%
    HttpSession misesion = request.getSession();
    if (misesion.getAttribute("eladministrador") == null) {
        response.sendRedirect("error.jsp");
    } else {
        Administrador adm = (Administrador) misesion.getAttribute("eladministrador");
        String nombre = adm.getNombres() + " " + adm.getApellidos();
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Intranet - <%= nombre %></title>
</head>
<body>
<jsp:include page="master.jsp"/>
<div class="container mt-5">
    <h2>Bienvenido, <%= nombre %>!</h2>
    <a href="cursoMan.jsp" class="btn btn-success">Mantenimiento de cursos</a>
</div>
</body>
<% } %>
</html>