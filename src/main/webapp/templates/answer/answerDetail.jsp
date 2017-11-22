<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Steven
  Date: 22.11.2017
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:bean name="de.nordakademie.multiplechoice.answer.ui.AnswerDetailAction" var="answer">
</s:bean>


<div class="row">
    <div class="col"><b>Id: </b><s:property value="answer.answerText"/></div>
</div>
<div class="row">
    <div class="col"><b>Titel: </b><s:property value="answer.trueOrFalse"/></div>
</div>
