<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 22.11.17
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="saveQuestionBlankText">
    <s:label value="Den Text eingeben und die Worte, welche später Lücken sein sollen mit $$ und %% umschließen.
    Beispiel: Wirtschaftsinformatik ist die Kombination aus $$Betriebswirtschaftslehre%% und Informatik."/>
    <s:textfield name="question.questionText" label="Lückentext"/>
    <s:textfield name="question.scorePerCorrectChoice" label="Punkte richtige Antwort"/>
    <s:textfield name="question.scorePerWrongChoice" label="Punkte falsche Antwort*"/>
    <s:textfield name="question.scorePerMissingChoice" label="Punkte fehlende Antwort*"/>
    <s:label value="* Minuszeichen nicht vergessen."/>
    <%--examID und questionID nur temporaer zum Testen--%>
    <s:textfield name="question.exam.id" label="ExamID"/>


    <s:submit value="Speichern"/>
</s:form>
