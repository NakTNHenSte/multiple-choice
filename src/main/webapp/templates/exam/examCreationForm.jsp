<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 09/11/2017
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<s:form action="saveExam">
    <s:hidden name="examId" value="%{exam.id}"/>
    <s:hidden name="userId" value="%{#session.userId}"/>
    <s:textfield name="exam.title" label="Prüfungstitel"/>
    <s:textfield name="exam.credits" label="Credits"/>
    <s:textfield name="exam.seminar" label="Seminar"/>
    <s:textfield name="exam.duration" label="Dauer (in Minuten)"/>
    <s:textfield name="exam.start" label="Startdatum"/>
    <s:textfield name="exam.end" label="Enddatum"/>
    <s:textfield name="exam.percentualSuccessThreshold" label="Prozentuale Bestehensgrenze"/>
    <s:submit value="Speichern" type="button" class="btn btn-primary"/>
</s:form>