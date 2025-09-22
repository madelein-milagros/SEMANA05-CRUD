<%--
  Created by IntelliJ IDEA.
  User: Milagros
  Date: 16/09/2025
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.tecsup.semana05crud.model.entities.Administrador" %>
<%@ page import="com.tecsup.semana05crud.services.CursoService" %>
<%@ page import="com.tecsup.semana05crud.services.impl.CursoServiceImpl" %>
<%@ page import="com.tecsup.semana05crud.model.entities.Curso" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession misesion = request.getSession();
    if (misesion.getAttribute("eladministrador") == null) {
        response.sendRedirect("error.jsp");
    } else {
        Administrador adm = (Administrador) misesion.getAttribute("eladministrador");
        String nombre = adm.getNombres() + " " + adm.getApellidos();
        String sid = request.getParameter("id");
        CursoService servicio = new CursoServiceImpl();
        Curso curso = servicio.buscar(sid);
        if (curso == null) {
            response.sendRedirect("cursoMan.jsp");
        }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Eliminar Curso - <%= nombre %></title>
</head>
<body>
<jsp:include page="master.jsp"/>
<div class="container p-4" style="margin-top: 70px;">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card">
                <div class="card-header bg-danger text-white">
                    <h3 class="text-uppercase mb-0">CONFIRMAR ELIMINACIÓN</h3>
                </div>
                <div class="card-body">
                    <div class="alert alert-warning">
                        <h4>¿Está seguro de que desea eliminar el siguiente curso?</h4>
                        <p><strong>Código:</strong> <%= curso.getCodigo() %></p>
                        <p><strong>Nombre:</strong> <%= curso.getNombre() %></p>
                        <p><strong>Créditos:</strong> <%= curso.getCreditos() %></p>
                    </div>
                    <form action="cController" method="get">
                        <input name="accion" type="hidden" value="eliminar"/>
                        <input name="txtCodigo" type="hidden" value="<%= curso.getCodigo() %>"/>
                        <div class="d-grid gap-2">
                            <button class="btn btn-danger" type="submit">
                                <i class="fa-solid fa-trash"></i> Sí, Eliminar
                            </button>
                            <a href="cursoMan.jsp" class="btn btn-secondary">
                                <i class="fa-solid fa-xmark"></i> Cancelar
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<% } %>
</html>