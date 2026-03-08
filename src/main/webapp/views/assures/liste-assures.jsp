<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Gestion des Assurés</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<div class="container">
    <h2>Gestion des Assurés</h2>

    <table border="1" style="border-collapse: collapse">
        <thead  style="background: #eee">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Salaire</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${assures}" var="a">
            <tr>
                <td>${a.id}</td>
                <td>${a.nom}</td>
                <td>${a.salaireMensuel} €</td>
                <td>
                    <div style="display: flex; gap: 10px; align-items: center;">
                        <form action="${pageContext.request.contextPath}/assures?action=updateSalaire" method="post" style="display: flex; gap: 5px;">
                            <input type="hidden" name="id" value="${a.id}">
                            <input type="number" step="0.01" name="salaire" value="${a.salaireMensuel}" style="width: 80px;">
                            <button type="submit" class="btn-save">Modifier</button>
                        </form>
                        <a href="${pageContext.request.contextPath}/assures?action=releve&id=${a.id}" class="btn-info">Relevé</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/" class="btn">Retour Dashboard</a>
</div>
</body>
</html>