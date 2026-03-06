package org.example.esocial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.esocial.service.CotisationService;
import org.example.esocial.service.DeclarationService;
import org.example.esocial.service.AssureService;
import org.example.esocial.model.Declaration;
import java.io.IOException;

@WebServlet("/cotisations")
public class CotisationServlet extends HttpServlet {
    private final CotisationService service = new CotisationService();
    private final DeclarationService declarationService = new DeclarationService();
    private final AssureService assureService = new AssureService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String declarationIdParam = request.getParameter("declarationId");

        if (declarationIdParam == null || declarationIdParam.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/declarations");
            return;
        }

        int decId = Integer.parseInt(declarationIdParam);
        Declaration dec = declarationService.trouverParId(decId);

        if (dec != null) {
            request.setAttribute("declaration", dec);
            request.setAttribute("declarationId", decId);
            request.setAttribute("cotisations", service.listerParDeclaration(decId));
            request.setAttribute("assures", assureService.listerParEmployeur(dec.getEmployeur().getId()));
        }

        request.getRequestDispatcher("/views/cotisations/liste-cotisations.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String assureIdParam = request.getParameter("assureId");
        String decIdParam = request.getParameter("declarationId");

        if (assureIdParam != null && decIdParam != null) {
            try {
                int assureId = Integer.parseInt(assureIdParam);
                int decId = Integer.parseInt(decIdParam);
                service.genererCotisation(assureId, decId);
                response.sendRedirect(request.getContextPath() + "/cotisations?declarationId=" + decId);
                return;
            } catch (NumberFormatException e) {

            }
        }
        response.sendRedirect(request.getContextPath() + "/declarations");
    }
}