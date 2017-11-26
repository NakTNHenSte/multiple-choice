<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 10.11.17
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<%--<s:form action="questionEdit">--%>
<s:form action="participateFillTheBlankTextQuestion">
    <s:hidden name="examId" value="%{exam.id}"/>
    <s:hidden name="currentQuestionIndex" value="%{currentQuestionIndex}"/>

    <s:label value="Bitte den Lückentext ausfüllen" class="h3"/>

    <table class="table">
        <tr>
            <th scope="col">Punkte Antwort korrekt</th>
            <th scope="col">Abzug Antwort falsch</th>
            <th scope="col">Abzug Antwort fehlt</th>
        </tr>
        <tr>
            <td><s:property value="question.scorePerCorrectChoice"/></td>
            <td><s:property value="question.scorePerWrongChoice"/> <s:property value="user.surname"/></td>
            <td><s:property value="question.scorePerMissingChoice"/></td>
        </tr>
    </table>

   <p><s:label name="question.questionText" class="h5"/></p>

    <p><s:label value="Bitte die Lücken hier füllen" class="h5"/></p>

    <s:iterator var="answer" value="answerList.answer" status="stat" begin="1" end="answerCount">
        <div align="left">
            <s:textfield name="givenAnswers[%{#stat.index}]" label="Lücke %{#stat.index + 1}"/>
        </div>
    </s:iterator>


    <s:submit value="Antwort(en) senden" type="button" class="btn btn-primary"/>
</s:form>
