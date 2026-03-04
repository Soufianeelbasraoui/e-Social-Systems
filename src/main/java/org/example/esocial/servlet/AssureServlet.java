
package org.example.esocial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.esocial.service.AssureService;
import java.io.IOException;

@WebServlet("/assures")
public class AssureServlet extends HttpServlet {
    private final AssureService service = new AssureService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empIdStr = request.getParameter("employeurId");

        if (empIdStr != null) {
            int empId = Integer.parseInt(empIdStr);
            request.setAttribute("assures", service.listerParEmployeur(empId));
            request.setAttribute("employeurId", empId);
            request.getRequestDispatcher("/views/assures/liste-par-employeur.jsp").forward(request, response);
        } else {
            request.setAttribute("assures", service.listerTout());
            request.getRequestDispatcher("/views/assures/liste-assures.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String nom = request.getParameter("nom");
            Double salaire = Double.parseDouble(request.getParameter("salaire"));
            int empId = Integer.parseInt(request.getParameter("employeurId"));
            service.ajouterAssure(nom, salaire, empId);
            response.sendRedirect("assures?employeurId=" + empId);
        } else if ("updateSalaire".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Double salaire = Double.parseDouble(request.getParameter("salaire"));
            service.modifierSalaire(id, salaire);
            response.sendRedirect("assures");
        }
    }
}