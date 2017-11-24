<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 10.11.17
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<s:form action="participateQuestion">
    <%--<s:hidden name="examId" value="%{exam.id}"/>--%>
    <%--<s:hidden name="questionId" value="%{questionId}"/>--%>
    <s:hidden name="examId" value="1234"/>
    <s:hidden name="questionId" value="1001"/>

    <s:textfield name="question.questionText" label="Fragentext"/>
    <s:textfield name="question.scorePerCorrectChoice" label="Punkte richtige Antwort"/>
    <s:textfield name="question.scorePerWrongChoice" label="Punkte falsche Antwort*"/>
    <s:textfield name="question.scorePerMissingChoice" label="Punkte fehlende Antwort*"/>
    <s:label value="* Minuszeichen nicht vergessen."/>

    <s:iterator var="answer" value="answerList.answer" status="stat" begin="1" end="answerCount">
        <s:textfield name="answerList[%{#stat.index}].answerText" label="Antwort %{#stat.index + 1}"/>
        <s:radio label="Wahr/Falsch" name="answerList[%{#stat.index}].trueOrFalse" list="#{'true':'Wahr','false':'Falsch'}"/>
    </s:iterator>

    <s:submit value="Antwort(en) senden" type="button" class="btn btn-primary"/>
</s:form>
