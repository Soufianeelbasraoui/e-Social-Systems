
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>details-declaration</title>
</head>
<body>
<div class="container">
    <h3>Déclaration de ${declaration.mois}/${declaration.annee}</h3>
    <p>Employeur : ${declaration.employeur.raisonSociale}</p>

    <table class="payroll-table">
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
        <c:set var="totalEmployeur" value="0" />
        <c:forEach items="${declaration.cotisations}" var="c">
            <tr>
                <td>${c.assure.nom}</td>
                <td>${c.assure.salaireMensuel} €</td>
                <td>${c.cotisationSalariale} €</td>
                <td>${c.cotisationPatronale} €</td>
                <td><strong>${c.cotisationSalariale + c.cotisationPatronale} €</strong></td>
            </tr>
            <c:set var="totalEmployeur" value="${totalEmployeur + c.cotisationSalariale + c.cotisationPatronale}" />
        </c:forEach>
        </tbody>
        <tfoot>
        <tr class="total-row">
            <td colspan="4">TOTAL À PAYER PAR L'EMPLOYEUR</td>
            <td>${totalEmployeur} €</td>
        </tr>
        </tfoot>
    </table>
</div>

</body>
</html>
