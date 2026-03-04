<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Détails - ${employeur.raisonSociale}</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
  <a href="${pageContext.request.contextPath}/employeurs">← Retour à la liste</a>

  <div class="profile-header card">
    <div class="info">
      <h1>${employeur.raisonSociale}</h1>
      <p>ID Employeur : <strong>#${employeur.id}</strong> | Secteur : <strong>${employeur.secteurActivite}</strong></p>
    </div>
  </div>

  <div class="main-grid">
    <div class="card">
      <h3>Associer un nouvel employé</h3>
      <form action="${pageContext.request.contextPath}/assures?action=add" method="post">
        <input type="hidden" name="employeurId" value="${employeur.id}">

        <label>Nom de l'employé</label>
        <input type="text" name="nom" required placeholder="Ex: Jean Dupont">

        <label>Salaire Mensuel Brut</label>
        <input type="number" name="salaire" step="0.01" required placeholder="0.00 €">

        <button type="submit" class="btn-block">Lier l'employé</button>
      </form>
    </div>

    <div class="card">
      <h3>Employés rattachés (${employeur.assures.size()})</h3>
      <table border="1" class="data-table">
        <thead>
        <tr>
          <th>Nom</th>
          <th>Salaire</th>
          <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employeur.assures}" var="a">
          <tr>
            <td>${a.nom}</td>
            <td>${a.salaireMensuel} €</td>
            <td>
              <a href="${pageContext.request.contextPath}/assures?action=edit&id=${a.id}" class="text-link">Modifier</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>