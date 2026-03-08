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

    <table border="1" style="border-collapse: collapse">
        <thead   style="background: #eee">
        <tr>
            <th>Employé</th>
            <th>Salaire déclaré</th>
            <th>Part Salariale (7%)</th>
            <th>Part Patronale (20%)</th>
            <th>Total Cotisation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${declaration.cotisations}" var="c">
            <tr>
                <td>${c.assure.nom}</td>
                <td>${c.assure.salaireMensuel} €</td>
                <td>${c.cotisationSalariale} €</td>
                <td>${c.cotisationPatronale} €</td>
                <td><strong>${c.cotisationSalariale + c.cotisationPatronale} €</strong></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr style="background: #eee;">
            <td colspan="4" style="text-align: right;"><strong>TOTAL À PAYER PAR L'EMPLOYEUR</strong></td>
            <td><strong>${declaration.montantTotal} €</strong></td>
        </tr>
        </tfoot>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/declarations" class="btn">Retour</a>
</div>
</body>
</html>