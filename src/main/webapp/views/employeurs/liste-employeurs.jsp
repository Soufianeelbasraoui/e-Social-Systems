<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gestion des Employeurs | e-Social</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <div class="header-action">
        <h1>Gestion des Employeurs</h1>
    </div>

    <section id="addForm" class="card" style="margin-bottom: 20px;">
        <h3>Enregistrer une nouvelle entreprise</h3>
        <form action="${pageContext.request.contextPath}/employeurs?action=add" method="post" class="horizontal-form">
            <input type="text" name="raisonSociale" placeholder="Raison Sociale" required>
            <input type="text" name="secteurActivite" placeholder="Secteur d'activité" required>
            <button type="submit" class="btn-save">Enregistrer</button>
        </form>
    </section>

    <div class="card">
        <table border="1" class="data-table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Raison Sociale</th>
                <th>Secteur d'Activité</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employeurs}" var="emp">
                <tr>
                    <td>#${emp.id}</td>
                    <td><strong>${emp.raisonSociale}</strong></td>
                    <td><span class="badge">${emp.secteurActivite}</span></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/employeurs?action=details&id=${emp.id}" class="btn-info"> Consulter</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>