<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Relevé de Droits - ${assure.nom}</title>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">--%>
    <link rel="stylesheet" href="/css/style.css">

</head>
<body>
<div class="container">
    <h2>Relevé de Droits Sociaux : ${assure.nom}</h2>
    <div  style="display: flex; gap: 15px; margin-bottom: 15px;">
        <div style=" white:100px; padding: 10px; border-radius: 5px;border: 1px solid">
            <h4> Ancienneté</h4>
            <p style="font-size: 24px; font-weight: bold;">${assure.cotisations.size()} mois déclarés</p>
        </div>
        <div style="white:100px; padding: 10px; border-radius: 5px; border: 1px solid;">
            <h4>Total des Cotisations</h4>
            <p style="font-size: 24px; font-weight: bold; color: #0d47a1;">
                <c:set var="total" value="0" />
                <c:forEach var="c" items="${assure.cotisations}">
                    <c:set var="total" value="${total + c.cotisationSalariale + c.cotisationPatronale}" />
                </c:forEach>
                ${total} €
            </p>
        </div>
    </div>

    <h3>Détail des périodes</h3>
    <table border="1" style="border-collapse: collapse">
        <thead  style="background: #eee">
        <tr>
            <th>Période</th>
            <th>Salaire Déclaré</th>
            <th>Part Salariale</th>
            <th>Part Patronale</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${assure.cotisations}" var="cotis">
            <tr>
                <td>${cotis.declaration.mois} / ${cotis.declaration.annee}</td>
                <td>${assure.salaireMensuel} €</td>
                <td>${cotis.cotisationSalariale} €</td>
                <td>${cotis.cotisationPatronale} €</td>
            </tr>
        </c:forEach>
        <c:if test="${empty assure.cotisations}">
            <tr><td colspan="4" style="text-align:center;">Aucun droit acquis pour le moment.</td></tr>
        </c:if>
        </tbody>
    </table>

    <p style="margin-top: 20px;">
        <a href="${pageContext.request.contextPath}/declarations" class="btn">Retour aux déclarations</a>
    </p>
</div>
</body>
</html>