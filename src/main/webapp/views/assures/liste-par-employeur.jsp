<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Gestion des Assurés - e-Social</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
  <header>
    <h2>Gestion des Assurés</h2>
    <p><strong>Employeur ID :</strong> ${employeurId}</p>
  </header>

  <hr>
  <section class="add-form">
    <h3>Déclarer un nouvel employé</h3>
    <form action="${pageContext.request.contextPath}/assures?action=add" method="post">
      <input type="hidden" name="employeurId" value="${employeurId}">

      <div class="form-group">
        <input type="text" name="nom" placeholder="Nom de l'employé" required>
        <input type="number" step="0.01" name="salaire" placeholder="Salaire mensuel (ex: 4500.00)" required>
        <button type="submit" class="btn-save">Ajouter l'employé</button>
      </div>
    </form>
  </section>

  <br>
  <table border="1" class="data-table">
    <thead>
    <tr>
      <th>ID</th>
      <th>Nom de l'Assuré</th>
      <th>Salaire Mensuel</th>
      <th>Mise à jour Salaire</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${assures}" var="a">
      <tr>
        <td>${a.id}</td>
        <td>${a.nom}</td>
        <td><strong>${a.salaireMensuel} €</strong></td>

      </tr>
    </c:forEach>

    <c:if test="${empty assures}">
      <tr>
        <td colspan="4" style="text-align: center;">Aucun assuré déclaré pour cet employeur.</td>
      </tr>
    </c:if>
    </tbody>
  </table>

  <footer style="margin-top: 20px;">
    <a href="${pageContext.request.contextPath}/employeurs" class="btn-back">← Retour à la liste des employeurs</a>
  </footer>
</div>
</body>
</html>