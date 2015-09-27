<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
  <meta charset="windows-1251">
  <title>Discipline Page</title>
  <style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
  </style>
</head>
<body>
<h1>
  Add a Discipline
</h1>
<meta charset="windows-1251">
<c:url var="addAction" value="/discipline/add" ></c:url>

<form:form action="${addAction}" commandName="discipline">
  <table>
    <meta charset="windows-1251">
    <c:if test="${!empty discipline.nameDiscipline}">
      <tr>
        <td>
          <form:label path="id">
            <spring:message text="ID"/>
          </form:label>
        </td>
        <td>
          <form:input path="id" readonly="true" size="8"  disabled="true" />
          <form:hidden path="id" />
        </td>
      </tr>
    </c:if>
    <tr>
      <td>
        <form:label path="nameDiscipline">
          <spring:message text=" Name Discipline"/>
        </form:label>
      </td>
      <td>
        <form:input path="nameDiscipline" />
      </td>
    </tr>

    <tr>
      <td colspan="2">
        <c:if test="${!empty discipline.nameDiscipline}">
          <input type="submit"
                 value="<spring:message text="Edit Discipline"/>" />
        </c:if>
        <c:if test="${empty discipline.nameDiscipline}">
          <input type="submit"
                 value="<spring:message text="Add Discipline"/>" />
        </c:if>
      </td>
    </tr>
  </table>
</form:form>
<br>
<h3>Discipline  List</h3>
<c:if test="${!empty listDisciplines}">
  <table class="tg">
    <tr>
      <th width="80">Disciplines ID</th>
      <th width="120">Name Disciplines</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listDisciplines}" var="discipline">
      <tr>
        <td>${discipline.id}</td>
        <td>${discipline.nameDiscipline}</td>

        <td><a href="<c:url value='/editDiscipline/${discipline.id}' />" >Edit</a></td>
        <td><a href="<c:url value='/removeDiscipline/${discipline.id}' />" >Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>