<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Gestion des Assurés</title>
</head>

<body>

<h2>Gestion des Assurés</h2>

<section style="margin-bottom:20px;">
    <h3>Ajouter un assuré</h3>

    <form action="${pageContext.request.contextPath}/assures?action=add" method="post">


        <input type="text" name="nom" placeholder="Nom" required>

        <input type="number" step="0.01" name="salaire" placeholder="Salaire" required>

        <button type="submit">Enregistrer</button>

    </form>
</section>

<table border="1">

    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Salaire</th>
        <th>Modifier salaire</th>
    </tr>

    <c:forEach items="${assures}" var="a">

        <tr>

            <td>${a.id}</td>

            <td>${a.nom}</td>

            <td>${a.salaireMensuel}</td>

            <td>

                <form action="${pageContext.request.contextPath}/assures?action=updateSalaire" method="post">

                    <input type="hidden" name="id" value="${a.id}">

                    <input type="number" name="salaire" value="${a.salaireMensuel}">

                    <button type="submit">Modifier</button>

                </form>

            </td>

        </tr>

    </c:forEach>

</table>

<br>

<a href="${pageContext.request.contextPath}/">Retour Dashboard</a>

</body>
</html>