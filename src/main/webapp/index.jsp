<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>e-Social Systems | Dashboard</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container">
  <section class="welcome">
    <h1>Bienvenue sur e-Social Systems</h1>
    <p>Plateforme de gestion simplifiée des cotisations et déclarations sociales.</p>
  </section>

  <div class="dashboard-grid">
    <a href="${pageContext.request.contextPath}/employeurs" class="card">
      <div class="icon"></div>
      <h3>Employeurs</h3>
      <p>Gérer les entreprises, ajouter de nouveaux adhérents et consulter leurs fiches.</p>
    </a>

    <a href="${pageContext.request.contextPath}/assures" class="card">
      <div class="icon"></div>
      <h3>Assurés</h3>
      <p>Liste globale des employés, mise à jour des salaires et suivi des affiliations.</p>
    </a>

    <a href="${pageContext.request.contextPath}/declarations" class="card">
      <div class="icon"></div>
      <h3>Déclarations</h3>
      <p>Ouvrir une période de déclaration mensuelle et calculer les cotisations.</p>
    </a>

  </div>

  <footer style="margin-top: 50px; text-align: center; opacity: 0.6;">
    <small>Session active | <a href="${pageContext.request.contextPath}/hello-servlet">Diagnostic Système</a></small>
  </footer>
</div>

</body>
</html>