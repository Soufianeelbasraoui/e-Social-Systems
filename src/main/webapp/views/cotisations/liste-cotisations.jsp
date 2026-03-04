<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Détails des Cotisations</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
  <h2>Cotisations pour la Déclaration n°${declarationId}</h2>

  <table border="1">
    <thead>
    <tr>
      <th>Assuré</th>
      <th>Salaire Base</th>
      <th>Part Patronale (20%)</th>
      <th>Part Salariale (7%)</th>
      <th>Total Cotisation</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cotisations}" var="c">
      <tr>
        <td>${c.assure.nom}</td>
        <td>${c.assure.salaireMensuel} €</td>
        <td style="color: blue;">${c.cotisationPatronale} €</td>
        <td style="color: green;">${c.cotisationSalariale} €</td>
        <td><strong>${c.cotisationPatronale + c.cotisationSalariale} €</strong></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <br>
  <a href="${pageContext.request.contextPath}/declarations" class="btn">Retour aux déclarations</a>
</div>
</body>
</html>