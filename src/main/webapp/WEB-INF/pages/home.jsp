<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Items to do: ${fn:length(items)}</h1>
<form:form modelAttribute="newItem">
    <table border="1">
        <tr>
            <th>Due Date</th>
            <th>Description</th>
        </tr>
        <c:forEach var="item" items="${items}">
            <tr>
                <td>${item.dueDate}</td>
                <td>${item.description}</td>
            </tr>
        </c:forEach>
        <tr>
            <td>
                <form:input path="dueDate"></form:input>
            </td>
            <td>

                <form:input path="description"></form:input>
            </td>
        </tr>
    </table>
    <button>Add new</button>
</form:form>


</body>
</html>