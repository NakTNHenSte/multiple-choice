<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 09.11.17
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table>
    <tr>
        <th>Id</th>
        <th>Frage</th>
        <th>Punkte pro korrekter Antwort</th>
        <th>Abzug pro falscher Antwort</th>
        <th>Abzug pro fehlender Antwort</th>
    </tr>
    <s:iterator value="questions">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="questionText"/></td>
            <td><s:property value="scorePerCorrectChoice"/></td>
            <td><s:property value="scorePerWrongChoice"/></td>
            <td><s:property value="scorePerMissingChoice"/></td>
        </tr>
    </s:iterator>
</table>