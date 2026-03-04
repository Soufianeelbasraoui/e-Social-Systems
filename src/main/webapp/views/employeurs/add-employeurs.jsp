<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter Employeur</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Nouvel Employeur</h2>
    <form action="${pageContext.request.contextPath}/employeurs" method="post">
        <label>Raison Sociale :</label> <input type="text" name="raisonSociale" placeholder="Ex: Entreprise Alpha SARL" required><br>
        <label>Secteur :</label> <input type="text" name="secteurActivite" placeholder="Ex: Informatique / Industrie" required><br>
        <button type="submit">Enregistrer</button>
    </form>
    <a href="${pageContext.request.contextPath}/employeurs">Retour à la liste</a>
</div>
</body>
</html>