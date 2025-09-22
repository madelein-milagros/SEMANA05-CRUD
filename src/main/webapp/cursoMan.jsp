<%--
  Created by IntelliJ IDEA.
  User: Milagros
  Date: 16/09/2025
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.tecsup.semana05crud.model.entities.Administrador" %>
<%@ page import="com.tecsup.semana05crud.services.CursoService" %>
<%@ page import="com.tecsup.semana05crud.services.impl.CursoServiceImpl" %>
<%@ page import="com.tecsup.semana05crud.model.entities.Curso" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%
    HttpSession misesion = request.getSession();
    if (misesion.getAttribute("eladministrador") == null) {
        response.sendRedirect("error.jsp");
    } else {
        Administrador adm = (Administrador) misesion.getAttribute("eladministrador");
        String nombre = adm.getNombres() + " " + adm.getApellidos();
        CursoService servicio = new CursoServiceImpl();
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mantenimiento de Cursos - <%= nombre %></title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<div class="container" style="margin-top: 70px;">
    <div class="row mt-5">
        <jsp:include page="master.jsp"/>
        <h1 class="mb-4">Mantenimiento de Cursos</h1>
        <div class="mb-3">
            <a class="btn btn-success" href="cursoInsertar.jsp">
                <i class="fa-solid fa-plus"></i> Nuevo Curso
            </a>
        </div>
        <table class="table table-striped table-hover">
            <thead class="table-dark">
            <tr align="center">
                <th>CÓDIGO</th>
                <th>NOMBRE</th>
                <th>CRÉDITOS</th>
                <th>ACCIONES</th>
            </tr>
            </thead>
            <tbody>
            <% for (Curso curso : servicio.listar()) { %>
            <tr>
                <td><%= curso.getCodigo() %></td>
                <td><%= curso.getNombre() %></td>
                <td><%= curso.getCreditos() %></td>
                <td>
                    <a class="btn btn-warning btn-sm" href="cursoEliminar.jsp?id=<%= curso.getCodigo() %>">
                        <i class="fa-solid fa-trash"></i> Borrar
                    </a>
                    <a class="btn btn-info btn-sm" href="cursoActualizar.jsp?id=<%= curso.getCodigo() %>">
                        <i class="fa-solid fa-pencil"></i> Actualizar
                    </a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
<% } %>
</html>