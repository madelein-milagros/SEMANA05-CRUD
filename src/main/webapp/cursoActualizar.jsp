<%--
  Created by IntelliJ IDEA.
  User: Milagros
  Date: 16/09/2025
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.tecsup.semana05crud.model.entities.Administrador" %>
<%@ page import="com.tecsup.semana05crud.model.entities.Curso" %>
<%@ page import="com.tecsup.semana05crud.services.CursoService" %>
<%@ page import="com.tecsup.semana05crud.services.impl.CursoServiceImpl" %>
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
    <title>Actualizar Curso - <%= nombre %></title>
</head>
<body>
<jsp:include page="master.jsp"/>
<div class="container p-4" style="margin-top: 70px;">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card">
                <div class="card-header bg-warning text-white">
                    <h3 class="text-uppercase mb-0">ACTUALIZAR CURSO</h3>
                </div>
                <div class="card-body">
                    <form action="cController" method="get">
                        <input name="accion" type="hidden" value="actualizar"/>
                        <div class="mb-3">
                            <label for="txtCodigo" class="form-label">Código:</label>
                            <input type="text" class="form-control" name="txtCodigo" id="txtCodigo" value="<%= curso.getCodigo() %>" readonly>
                        </div>
                        <div class="mb-3">
                            <label for="txtNombre" class="form-label">Nombre:</label>
                            <input type="text" class="form-control" name="txtNombre" id="txtNombre" value="<%= curso.getNombre() %>" required>
                        </div>
                        <div class="mb-3">
                            <label for="txtCreditos" class="form-label">Créditos:</label>
                            <input type="number" class="form-control" name="txtCreditos" id="txtCreditos" value="<%= curso.getCreditos() %>" required>
                        </div>
                        <div class="d-grid gap-2">
                            <button class="btn btn-primary" type="submit">
                                <i class="fa-solid fa-floppy-disk"></i> Actualizar
                            </button>
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