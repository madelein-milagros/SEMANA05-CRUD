package com.tecsup.semana05crud.controllers;

import com.tecsup.semana05crud.model.entities.Administrador;
import com.tecsup.semana05crud.services.AdministradorService;
import com.tecsup.semana05crud.services.impl.AdministradorServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdministradorController", urlPatterns = {"/sValidador", "/admin"})
public class AdministradorController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sUsuario = request.getParameter("txtUsuario");
        String sPassword = request.getParameter("txtPassword");

        System.out.println("🔑 Usuario recibido: " + sUsuario);
        System.out.println("🔑 Password recibido: " + sPassword);

        AdministradorService servicio = new AdministradorServiceImpl();
        Administrador adm = servicio.validar(sUsuario, sPassword);

        if (adm != null) {
            System.out.println("✅ Login correcto: " + adm);
            request.getSession().setAttribute("eladministrador", adm);
            response.sendRedirect("principal.jsp");
        } else {
            System.out.println("❌ Login fallido");
            response.sendRedirect("error.jsp");
        }
    }
}
