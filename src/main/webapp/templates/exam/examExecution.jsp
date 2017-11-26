<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 24/11/2017
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div align="right">
<s:form action="finishExam">
    <s:hidden name="examId" value="%{exam.id}"/>
    <s:submit value="Prüfung beenden" type="button" class="btn btn-primary"/>
</s:form>
</div>

<s:if test='%{question.questionType == ("multiple")}'>
<s:include value="/templates/question/questionParticipate.jsp"></s:include>
</s:if>

<s:if test='%{question.questionType == ("gap")}'>
<s:include value="/templates/question/questionFillTheBlankTextParticipate.jsp"></s:include>
</s:if>

<s:if test='%{currentQuestionIndex > 0}'>
<s:form action="previousQuestion">
    <s:hidden name="examId" value="%{exam.id}"/>
    <s:hidden name="currentQuestionIndex" value="%{currentQuestionIndex}"/>
    <s:submit value="zurück" type="button" class="btn btn-secondary"/>
</s:form>
</s:if>

<s:if test='%{currentQuestionIndex < questions.size()-1}'>
<s:form action="nextQuestion">
    <s:hidden name="examId" value="%{exam.id}"/>
    <s:hidden name="currentQuestionIndex" value="%{currentQuestionIndex}"/>
    <s:submit value="weiter" type="button" class="btn btn-primary"/>
</s:form>
</s:if>
