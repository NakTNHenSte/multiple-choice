<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 18/11/2017
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:bean name="de.nordakademie.multiplechoice.exam.ui.ExamDetailAction" var="exam">
</s:bean>





<div class="row">
    <div class="col"><b>Id: </b><s:property value ="exam.id"/></div>
</div>
<div class="row">
    <div class="col"><b>Titel: </b><s:property value ="exam.title"/></div>
</div>
<div class="row">
    <div class="col"><b>Dozent: </b><s:property value ="exam.user"/></div>
</div>
<div class="row">
    <div class="col"><b>Seminar: </b><s:property value ="exam.seminar"/></div>
</div>
<div class="row">
    <div class="col"><b>Credits: </b><s:property value ="exam.credits"/></div>
</div>
<div class="row">
    <div class="col"><b>Prüfungszeitraum: </b><s:property value ="exam.start"/> - <s:property value ="exam.end"/></div>
</div>

<div class="row">
    <div class="col"><b>Prozentuale Punktzahl zum bestehen der Prüfung: </b><s:property value ="exam.percentualSuccessThreshold"/></div>
</div>
<div class="row">
    <div class="col"><b>Dauer eines Prüfungsdurchlaufs: </b><s:property value ="exam.duration"/></div>
</div>
