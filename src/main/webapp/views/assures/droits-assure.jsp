
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h2>Relevé de Droits : ${assure.nom}</h2>

    <div class="stats-grid">
        <div class="card">
            <h4>Ancienneté</h4>
            <p class="value">${nbMoisDeclares} mois</p>
        </div>
        <div class="card">
            <h4>Total Cotisé (Cumul)</h4>
            <p class="value">${totalCotisations} €</p>
        </div>
    </div>

    <h3>Détail des périodes déclarées</h3>
    <table>
        <tr><th>Période</th><th>Salaire</th><th>Cotisation versée</th></tr>
        <c:forEach items="${assure.cotisations}" var="cotis">
            <tr>
                <td>${cotis.declaration.mois}/${cotis.declaration.annee}</td>
                <td>${assure.salaireMensuel} €</td>
                <td>${cotis.cotisationSalariale + cotis.cotisationPatronale} €</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
