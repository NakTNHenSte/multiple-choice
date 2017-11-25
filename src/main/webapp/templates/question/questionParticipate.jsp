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

    <s:label name="question.questionText" class="h3"/>

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

    <s:label value="Mögliche Antworten" class="h5"/>

    <s:iterator var="answer" value="answerList.answer" status="stat" begin="1" end="answerCount">
        <div align="left">
            <s:textarea name="answerList[%{#stat.index}].answerText" readonly="true"/>
                <%--<s:label name="answerList[%{#stat.index}].answerText" class="h5"/>--%>
            <s:radio name="givenAnswers[%{#stat.index}]"
                     list="#{'true':'Wahr','false':'Falsch'}"/>
        </div>
    </s:iterator>

    <s:hidden name="examId" value="%{exam.id}"/>
    <s:hidden name="currentQuestionIndex" value="%{currentQuestionIndex}"/>
    <s:submit value="Antwort(en) senden" type="button" class="btn btn-primary"/>
</s:form>