<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<head>
  <title>Journal Page</title>
  <style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
  </style>
</head>




<br>

<h3>Student  List</h3>


  <table class="tg">
    <tr>
      <td class="heading">Id</td>
      <td class ="heading">First Name</td>
      <td class = "heading">Second Name</td>
      <td class = "heading">Name Discipline</td>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>

    <c:forEach items="${journalsList}" var="student" >

      <c:forEach items="${student.disciplines}" var="discipline" >

        <td>
            ${student.id}
        </td>
        <td>
            ${student.firstName}
        </td>
        <td>
                ${student.secondName}
        </td>

        <td>
            ${discipline.nameDiscipline}
        </td>

        <td><a href="<c:url value='/editJournal/${journal.id}' />" >Edit</a></td>
        <td><a href="<c:url value='/removeJournal/${student.id}' />" >Delete</a></td>
      </tr>

      </c:forEach>

    </c:forEach>
  </table>



</body>
</html>