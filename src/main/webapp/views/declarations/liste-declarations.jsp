
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>liste_declaration</title>
</head>
<body>
<div class="container">
    <h2>Déclarations Sociales - Employeur n°${employeurId}</h2>

    <form action="declarations" method="post">
        <input type="hidden" name="employeurId" value="${employeurId}">
        <select name="mois">
            <option value="1">Janvier</option><option value="2">Février</option>
        </select>
        <input type="number" name="annee" value="2026">
        <button type="submit">Ouvrir une période</button>
    </form>

    <table border="1">
        <thead>
        <tr>
            <th>Période</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${declarations}" var="d">
            <tr>
                <td>${d.mois} / ${d.annee}</td>
                <td>
                        <%-- Lien vers le calcul des cotisations pour cette période --%>
                    <a href="${pageContext.request.contextPath}/cotisations?declarationId=${d.id}">
                        Calculer/Voir Cotisations
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/employeurs">Retour</a>
</div>
</body>
</html>
