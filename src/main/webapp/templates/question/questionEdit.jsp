<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 10.11.17
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<s:form action="saveQuestion">
    <s:textfield name="question.questionText" label="Fragentext"/>
    <s:textfield name="question.scorePerCorrectChoice" label="Punkte richtige Antwort"/>
    <s:textfield name="question.scorePerWrongChoice" label="Punkte falsche Antwort*"/>
    <s:textfield name="question.scorePerMissingChoice" label="Punkte fehlende Antwort*"/>
    <s:label value="* Minuszeichen nicht vergessen."/>
    <s:hidden name="examId" value="%{exam.id}"/>

    <%--examID und questionID nur temporaer zum Testen--%>
    <%--<s:textfield name="question.exam.id" label="ExamID"/>--%>

    <s:iterator var="answer" value="answerList.answer" status="stat" begin="1" end="answerCount">
        <s:textfield name="answerList[%{#stat.index}].answerText" label="Antwort %{#stat.index + 1}"/>
        <s:checkbox name="answerList[%{#stat.index}].trueOrFalse" fieldValue="true" label="wahr"/>
    </s:iterator>

    <s:form action="questionEdit">
        <s:submit value="Abbrechen" type="button" class="btn btn-secondary"/>
    </s:form>

    <s:submit value="Speichern" type="button" class="btn btn-primary"/>
</s:form>

<s:form action="cancelQuestionEdit">
    <s:submit value="Abbrechen" type="button" class="btn btn-secondary"/>
</s:form>
