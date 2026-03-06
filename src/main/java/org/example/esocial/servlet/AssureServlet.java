package org.example.esocial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.esocial.service.AssureService;
import org.example.esocial.model.Assure;

import java.io.IOException;
import java.util.List;

@WebServlet("/assures")
public class AssureServlet extends HttpServlet {

    private AssureService service = new AssureService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String employeurId = request.getParameter("employeurId");

        if (employeurId != null) {
            int id = Integer.parseInt(employeurId);
            List<Assure> assures = service.listerParEmployeur(id);
            request.setAttribute("assures", assures);
            request.setAttribute("employeurId", id);
            request.getRequestDispatcher("/views/assures/liste-assures.jsp").forward(request, response);
            return;
        }

        String action = request.getParameter("action");
        if ("releve".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Assure assure = service.trouverParId(id);
            request.setAttribute("assure", assure);
            request.getRequestDispatcher("/views/assures/releve-droits.jsp").forward(request, response);
            return;
        }


        List<Assure> assures = service.listerTout();
        request.setAttribute("assures", assures);
        request.getRequestDispatcher("/views/assures/liste-assures.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {

            String nom = request.getParameter("nom");
            double salaire = Double.parseDouble(request.getParameter("salaire"));
            int empId = Integer.parseInt(request.getParameter("employeurId"));
            service.ajouterAssure(nom, salaire, empId);
            response.sendRedirect("assures?employeurId=" + empId);
        }

        if ("updateSalaire".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            double salaire = Double.parseDouble(request.getParameter("salaire"));

            service.modifierSalaire(id, salaire);

            response.sendRedirect("assures");
        }

    }
}