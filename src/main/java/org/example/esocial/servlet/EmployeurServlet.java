package org.example.esocial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.esocial.service.EmployeurService;

import java.io.IOException;

@WebServlet("/employeurs")
public class EmployeurServlet extends HttpServlet {
    private EmployeurService service = new EmployeurService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employeurs", service.listerTout());
        request.getRequestDispatcher("/WEB-INF/views/liste-employeurs.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String nom = request.getParameter("raisonSociale");
        String secteur = request.getParameter("secteurActivite");
        service.enregistrerEmployeur(nom, secteur);
        response.sendRedirect("employeurs"); // Recharge la liste
    }
}