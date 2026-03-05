//
//package org.example.esocial.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//import org.example.esocial.service.CotisationService;
//import org.example.esocial.service.DeclarationService;
//
//import java.io.IOException;
//
//@WebServlet("/declarations")
//public class DeclarationServlet extends HttpServlet {
//    private final DeclarationService service = new DeclarationService();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int empId = Integer.parseInt(request.getParameter("employeurId"));
//        request.setAttribute("declarations", service.listerParEmployeur(empId));
//        request.setAttribute("employeurId", empId);
//        request.getRequestDispatcher("/views/declarations/liste-declarations.jsp").forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        int mois = Integer.parseInt(request.getParameter("mois"));
//        int annee = Integer.parseInt(request.getParameter("annee"));
//        int empId = Integer.parseInt(request.getParameter("employeurId"));
//
//        service.creerDeclaration(mois, annee, empId);
//        response.sendRedirect("declarations?employeurId=" + empId);
//    }
//}