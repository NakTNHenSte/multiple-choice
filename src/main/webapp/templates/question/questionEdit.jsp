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
    <s:textfield name="question.scorePerCorrectChoice" label="Punkte korrekte Antwort"/>
    <s:textfield name="question.scorePerWrongChoice" label="Malus falsche Antwort "/>
    <s:textfield name="question.scorePerMissingChoice" label="Malus fehlende Antwort"/>
    <%--examID nur temporaer zum Testen--%>
    <s:textfield name="question.exam.id" label="ExamID"/>
    
    <%--<s:action name="addAnswer" executeResult="true"/>--%>

    <s:submit value="Speichern"/>
</s:form>
