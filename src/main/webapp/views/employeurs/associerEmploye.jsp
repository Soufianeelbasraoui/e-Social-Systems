<%--
  Created by IntelliJ IDEA.
  User: soufiane
  Date: 04/03/2026
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="actions">
    <%-- Lien vers le formulaire d'ajout --%>
    <a href="${pageContext.request.contextPath}/views/employeurs/add-employeurs.jsp" class="btn">
        Ajouter un employeur
    </a>
</div>

<table>
    <c:forEach items="${employeurs}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.raisonSociale}</td>
            <td>
                    <%-- Consulter par ID --%>
                <a href="${pageContext.request.contextPath}/employeurs?action=details&id=${emp.id}">Détails</a>
                    <%-- Associer des employés --%>
                <a href="${pageContext.request.contextPath}/assures?employeurId=${emp.id}">Associer employés</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
