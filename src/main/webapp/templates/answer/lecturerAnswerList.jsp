<%--
  Created by IntelliJ IDEA.
  User: Steven
  Date: 09.11.2017
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table>
    <tr>
        <th>Antwort</th>
        <th>Wahr/Falsch</th>
    </tr>
    <s:iterator value="answers">
        <tr>
            <td><s:property value="answerText"/></td>
            <td><s:property value="trueOrFalse"/></td>
            <td><a href = "<s:url action="deleteAnswer"><s:param name="answerID" value="answerID"/></s:url>"> Löschen </a></td>
            <td><s:a href="answerDetail?answerID=%{answerID}"> <s:property value="answerID"/></s:a></td>
        </tr>
    </s:iterator>
</table>
