<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
  <title>Journal Page</title>
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

<c:url var="addAction" value="/journal/add" ></c:url>

<form:form action="${addAction}" commandName="journal">
  <table>

    <tr>
      <td>Student Id :</td>
      <td><form:input path="studentId" disabled="false"/></td>
    </tr>
    <tr>
      <td> Discipline Id:</td>
      <td><form:input path="disciplineId" disabled="false"/></td>
    </tr>

    <tr>
      <td colspan="2">

          <input type="submit"
                 value="<spring:message text="Add Journal"/>" />

      </td>
    </tr>
  </table>
</form:form>
<br>
<h3>Student  List</h3>
<c:if test="${!empty listJournals}">
  <table class="tg">
    <tr>
      <td class="heading">Id</td>
      <td class ="heading">First Name</td>
      <td class = "heading">Second Name</td>
      <td class = "heading">Name Discipline</td>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listJournals}" var="journal">
      <tr>
        <td>
            ${journal.journal.id}
        </td>
        <td>
            ${journal.student.secondName}
        </td>
        <td>
            ${journal.student.firstName}
        </td>
        <td>
            ${journal.discipline.nameDiscipline}
        </td>

        <td><a href="<c:url value='/editJournal/${journal.id}' />" >Edit</a></td>
        <td><a href="<c:url value='/removeJournal/${journal.id}' />" >Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>