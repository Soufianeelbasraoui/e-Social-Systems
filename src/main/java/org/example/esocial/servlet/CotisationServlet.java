package org.example.esocial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.esocial.service.CotisationService;
import java.io.IOException;

@WebServlet("/cotisations")
public class CotisationServlet extends HttpServlet {
    private final CotisationService service = new CotisationService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int decId = Integer.parseInt(request.getParameter("declarationId"));

        request.setAttribute("cotisations", service.listerParDeclaration(decId));
        request.setAttribute("declarationId", decId);

        request.getRequestDispatcher("/views/cotisations/liste-cotisations.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int assureId = Integer.parseInt(request.getParameter("assureId"));
        int decId = Integer.parseInt(request.getParameter("declarationId"));

        service.genererCotisation(assureId, decId);

        response.sendRedirect(request.getContextPath() + "/cotisations?declarationId=" + decId);
    }
}