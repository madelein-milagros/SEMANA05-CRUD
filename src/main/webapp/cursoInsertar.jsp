<%--
  Created by IntelliJ IDEA.
  User: Milagros
  Date: 16/09/2025
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.tecsup.semana05crud.model.entities.Administrador" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
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
    <title>Nuevo Curso - <%= nombre %></title>
</head>
<body>
<jsp:include page="master.jsp"/>
<div class="container p-4" style="margin-top: 70px;">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h3 class="text-uppercase mb-0">CREAR NUEVO CURSO</h3>
                </div>
                <div class="card-body">
                    <form action="cController" method="get">
                        <input name="accion" type="hidden" value="insertar"/>
                        <div class="mb-3">
                            <label for="txtCodigo" class="form-label">Código:</label>
                            <input type="text" class="form-control" name="txtCodigo" id="txtCodigo" placeholder="Ej: CS101" required>
                        </div>
                        <div class="mb-3">
                            <label for="txtNombre" class="form-label">Nombre:</label>
                            <input type="text" class="form-control" name="txtNombre" id="txtNombre" placeholder="Ej: Programación Web" required>
                        </div>
                        <div class="mb-3">
                            <label for="txtCreditos" class="form-label">Créditos:</label>
                            <input type="number" class="form-control" name="txtCreditos" id="txtCreditos" placeholder="Ej: 4" required>
                        </div>
                        <div class="d-grid gap-2">
                            <button class="btn btn-success" type="submit">
                                <i class="fa-solid fa-floppy-disk"></i> Insertar
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