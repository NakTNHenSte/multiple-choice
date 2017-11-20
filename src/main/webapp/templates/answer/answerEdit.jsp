<%--
  Created by IntelliJ IDEA.
  User: Steven
  Date: 19.11.2017
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<s:form action="saveAnswer">
    <s:textfield name="answer.answerText" label="AntwortText"/>
    <s:textfield name="answer.question.id" label="Frage"/>
    <s:radio label="Wahr/Falsch" name="answer.trueOrFalse" list="#{'true':'Wahr','false':'Falsch'}"/>
    <s:submit value="Send"/>
</s:form>
