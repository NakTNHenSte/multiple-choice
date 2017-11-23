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
    </tr>
    <s:iterator value="answers">
        <tr>
            <td><s:property value="answerText"/></td>
            <s:radio label="Wahr/Falsch" name="answer.trueOrFalse" list="#{'true':'Wahr','false':'Falsch'}"/>
        </tr>
    </s:iterator>
</table>