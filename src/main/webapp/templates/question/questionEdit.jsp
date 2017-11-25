<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 10.11.17
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="viewQuestionEdit">
    <s:hidden name="examId" value="%{exam.id}"/>
    <s:hidden name="questionId" value="%{questionId}"/>
    <s:textfield name="question.questionText" label="Fragentext"/>
    <s:textfield name="question.scorePerCorrectChoice" label="Punkte richtige Antwort"/>
    <s:textfield name="question.scorePerWrongChoice" label="Punkte falsche Antwort*"/>
    <s:textfield name="question.scorePerMissingChoice" label="Punkte fehlende Antwort*"/>
    <s:label value="* Minuszeichen nicht vergessen."/>

    <s:submit value="Frage speichern" type="button" class="btn btn-primary"/>

</s:form>

<s:form action="viewAnswerEdit">
    <table class="table table-sm">
        <s:iterator var="answer" value="answerList.answer" status="stat" begin="1" end="answerCount">
            <tr>
                <td><s:textfield name="answerList[%{#stat.index}].answerText" label="Antwort %{#stat.index + 1}"/></td>
                <td><s:radio label="Wahr/Falsch" name="answerList[%{#stat.index}].trueOrFalse"
                             list="#{'true':'Wahr','false':'Falsch'}"/></td>
                <td><s:form action="deleteAnswer">
                    <s:hidden name="positionOfAnswer" value="%{#stat.index}"/>
                    <s:hidden name="questionId" value="%{questionId}"/>
                    <s:submit value="löschen" type="button" class="btn btn-danger"/>
                </s:form>
                </td>
            </tr>
        </s:iterator>
    </table>
    <s:hidden name="examId" value="%{exam.id}"/>
    <s:submit value="Antworten speichern" type="button" class="btn btn-primary"/>
</s:form>


<s:form action="cancelQuestionEdit">
    <s:hidden name="examId" value="%{examId}"/>
    <s:submit value="Abbrechen" type="button" class="btn btn-secondary"/>
</s:form>