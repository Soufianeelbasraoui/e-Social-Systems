<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Détails Déclaration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h3>Déclaration de ${declaration.mois}/${declaration.annee}</h3>
    <p>Employeur : ${declaration.employeur.raisonSociale}</p>

    <c:set var="tauxS" value="5.0" />
    <c:set var="tauxP" value="10.0" />
    <c:set var="totalEmployeur" value="0.0" />

    <table border="1">
        <thead>
        <tr>
            <th>Employé</th>
            <th>Salaire déclaré</th>
            <th>Part Salariale (${tauxS}%)</th>
            <th>Part Patronale (${tauxP}%)</th>
            <th>Total Cotisation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${declaration.cotisations}" var="c">
            <c:set var="partS" value="${c.cotisationSalariale != null ? c.cotisationSalariale : 0}" />
            <c:set var="partP" value="${c.cotisationPatronale != null ? c.cotisationPatronale : 0}" />
            <tr>
                <td>${c.assure.nom}</td>
                <td>${c.assure.salaireMensuel} €</td>
                <td>${partS} €</td>
                <td>${partP} €</td>
                <td><strong>${partS + partP} €</strong></td>
            </tr>
            <c:set var="totalEmployeur" value="${totalEmployeur + partS + partP}" />
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="4">TOTAL À PAYER PAR L'EMPLOYEUR</td>
            <td>${totalEmployeur} €</td>
        </tr>
        </tfoot>
    </table>

    <a href="${pageContext.request.contextPath}/declarations?employeurId=${declaration.employeur.id}">Retour</a>
</div>
</body>
</html>