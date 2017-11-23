<%--
  Created by IntelliJ IDEA.
  User: Steven
  Date: 19.11.2017
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:iterator var="answer" value="answerList.answer" status="stat" begin="1" end="answerCount">
    <s:textfield name="answerList[%{#stat.index}].answerText" label="Antwort %{#stat.index + 1}"/>
    <s:checkbox name="answerList[%{#stat.index}].trueOrFalse" fieldValue="true" label="wahr"/>
</s:iterator>





<%--<s:form action="saveAnswer">--%>
    <%--<s:textfield name="answer.answerText" label="Antworttext"/>--%>
    <%--<s:radio label="Wahr/Falsch" name="answer.trueOrFalse" list="#{'true':'Wahr','false':'Falsch'}"/>--%>
<%--</s:form>--%>
