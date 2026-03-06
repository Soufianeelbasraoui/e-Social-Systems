
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Déclarations Sociales</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container">

    <h2>Déclarations Sociales - Employeur n° ${employeurId}</h2>

    <!-- Formulaire création déclaration -->

    <h3>Créer une déclaration</h3>
    <form action="${pageContext.request.contextPath}/declarations" method="post">

        <select name="employeurId" required>

            <option value="">Choisir Employeur</option>

            <c:forEach items="${employeurs}" var="e">

                <option value="${e.id}">
                        ${e.raisonSociale}
                </option>

            </c:forEach>

        </select>

        <select name="mois">

            <option value="1">Janvier</option>
            <option value="2">Février</option>
            <option value="3">Mars</option>
            <option value="4">Avril</option>
            <option value="5">Mai</option>
            <option value="6">Juin</option>
            <option value="7">Juillet</option>
            <option value="8">Août</option>
            <option value="9">Septembre</option>
            <option value="10">Octobre</option>
            <option value="11">Novembre</option>
            <option value="12">Décembre</option>

        </select>

        <input type="number" name="annee" value="2026">

        <button type="submit">Créer Déclaration</button>

    </form>

    <hr>

    <!-- Liste des déclarations -->

    <h3>Liste des déclarations</h3>

    <table border="1">

        <thead>
        <tr>
            <th>ID</th>
            <th>Mois</th>
            <th>Année</th>
            <th>Date déclaration</th>
            <th>Actions</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach items="${declarations}" var="d">

            <tr>

                <td>${d.id}</td>

                <td>${d.mois}</td>

                <td>${d.annee}</td>

                <td>${d.dateDeclaration}</td>

                <td>
                    <a href="${pageContext.request.contextPath}/cotisations?declarationId=${d.id}">
                        Voir cotisations
                    </a>
                    <hr>

                </td>

            </tr>

        </c:forEach>

        </tbody>

    </table>

    <br>

    <a href="${pageContext.request.contextPath}/employeurs">Retour</a>

</div>

</body>
</html>