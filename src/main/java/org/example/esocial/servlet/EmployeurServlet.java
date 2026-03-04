package org.example.esocial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.esocial.service.EmployeurService;
import org.example.esocial.model.Employeur;
import java.io.IOException;

@WebServlet("/employeurs")
public class EmployeurServlet extends HttpServlet {
    private final EmployeurService service = new EmployeurService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Logique pour consulter un employeur par ID
        if ("details".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Employeur emp = service.trouverParId(id);
            request.setAttribute("employeur", emp);
            request.getRequestDispatcher("/views/employeurs/details-employeur.jsp").forward(request, response);
        }

        else {
            request.setAttribute("employeurs", service.listerTout());
            request.getRequestDispatcher("/views/employeurs/liste-employeurs.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("raisonSociale");
        String secteur = request.getParameter("secteurActivite");

        service.enregistrerEmployeur(nom, secteur);

        response.sendRedirect(request.getContextPath() + "/employeurs");
    }
}