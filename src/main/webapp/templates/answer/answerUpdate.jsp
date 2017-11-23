<%--
  Created by IntelliJ IDEA.
  User: Steven
  Date: 23.11.2017
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table>
    <s:iterator value="answers">
        <tr>
            <s:textfield name="answerText" label="Antwort"/>
            <s:textfield name="trueOrFalse" label="Wahr/Falsch"/>
        </tr>
    </s:iterator>
</table>
