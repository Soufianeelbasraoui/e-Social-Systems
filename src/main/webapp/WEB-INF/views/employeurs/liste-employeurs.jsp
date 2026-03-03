<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Gestion des Employeurs - e-Social</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h1>Liste des Employeurs</h1>

    <div class="actions">
        <a href="${pageContext.request.contextPath}/add-employeur.jsp" class="btn">
            Ajouter un employeur
        </a>
    </div>

    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Raison Sociale</th>
            <th>Secteur d'Activité</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${employeurs}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.raisonSociale}</td>
                <td>${emp.secteurActivite}</td>
                <td>
                    <a href="details?id=${emp.id}">Détails</a> |
                    <a href="assures?employeurId=${emp.id}">Voir employés</a>
                </td>
            </tr>
        </c:forEach>

        <c:if test="${empty employeurs}">
            <tr>
                <td colspan="4" style="text-align:center;">
                    Aucun employeur trouvé.
                </td>
            </tr>
        </c:if>

        </tbody>
    </table>
</div>
</body>
</html>