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
  <h3>Déclaration de ${declaration.mois}/${declaration.annee}</h3>
  <p>Employeur : <strong>${declaration.employeur.raisonSociale}</strong></p>

  <section class="card" style="margin-bottom: 20px;">
    <h3>Ajouter un assuré à cette déclaration</h3>
    <form action="${pageContext.request.contextPath}/cotisations" method="post" class="horizontal-form">
      <input type="hidden" name="declarationId" value="${declarationId}">
      <select name="assureId" required>
        <option value="">-- Choisir un employé --</option>
        <c:forEach items="${assures}" var="a">
          <option value="${a.id}">${a.nom} (Salaire: ${a.salaireMensuel} €)</option>
        </c:forEach>
      </select>
      <button type="submit" class="btn-save">Enregistrer Salaire</button>
    </form>
  </section>

  <table border="1" class="data-table">
    <thead>
    <tr>
      <th>Assuré</th>
      <th>Salaire Base</th>
      <th>Part Patronale (20%)</th>
      <th>Part Salariale (7%)</th>
      <th>Total Cotisation</th>
      <th>Actions</th>
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
        <td>
          <a href="${pageContext.request.contextPath}/assures?action=releve&id=${c.assure.id}" class="btn">Voir Relevé</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr style="background: #f0f0f0;">
      <td colspan="4" style="text-align: right;"><strong>Total Général :</strong></td>
      <td><strong>${declaration.montantTotal} €</strong></td>
      <td></td>
    </tr>
    </tfoot>
  </table>

  <br>
  <a href="${pageContext.request.contextPath}/declarations" class="btn">Retour aux déclarations</a>
</div>
</body>
</html>