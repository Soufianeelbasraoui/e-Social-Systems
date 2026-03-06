
package org.example.esocial.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.example.esocial.service.DeclarationService;
import org.example.esocial.service.EmployeurService;

import java.io.IOException;

@WebServlet("/declarations")
public class DeclarationServlet extends HttpServlet {

    private DeclarationService declarationService = new DeclarationService();
    private EmployeurService employeurService = new EmployeurService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("declarations", declarationService.listerToutesDeclarations());
        request.setAttribute("employeurs", employeurService.listerTout());

        request.getRequestDispatcher("/views/declarations/liste-declarations.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int mois = Integer.parseInt(request.getParameter("mois"));
        int annee = Integer.parseInt(request.getParameter("annee"));
        int employeurId = Integer.parseInt(request.getParameter("employeurId"));

        declarationService.creerDeclaration(mois, annee, employeurId);



        response.sendRedirect("declarations");

    }
}