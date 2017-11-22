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
    <div class="col"><b>Id: </b><s:property value="exam.id"/></div>
</div>
<div class="row">
    <div class="col"><b>Titel: </b><s:property value="exam.title"/></div>
</div>
<div class="row">
    <div class="col"><b>Dozent: </b><s:property value="exam.user"/></div>
</div>
<div class="row">
    <div class="col"><b>Seminar: </b><s:property value="exam.seminar"/></div>
</div>
<div class="row">
    <div class="col"><b>Credits: </b><s:property value="exam.credits"/></div>
</div>
<div class="row">
    <div class="col"><b>Prüfungszeitraum: </b><s:property value="exam.start"/> - <s:property value="exam.end"/></div>
</div>

<div class="row">
    <div class="col"><b>Prozentuale Punktzahl zum bestehen der Prüfung: </b><s:property
            value="exam.percentualSuccessThreshold"/></div>
</div>
<div class="row">
    <div class="col"><b>Dauer eines Prüfungsdurchlaufs: </b><s:property value="exam.duration"/> Minuten</div>
</div>

<s:if test='%{#session.userTyp == ("S")}'>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#confirmationModal">
        Prüfung starten
    </button>
    <!-- Modal -->
    <div class="modal fade" id="confirmationModal" tabindex="-1" role="dialog" aria-labelledby="confirmationModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmationModalLabel">Prüfungsstart bestätigen</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Sind Sie sicher, dass Sie die Prüfung starten wollen? Mit dem Start der Prüfung beginnt der Ablauf der
                    Dauer des Prüfungsdurchlaufs.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Schließen</button>
                    <s:form action="runExam">
                        <s:submit value="Bestätigen" type="button" class="btn btn-primary"/>
                    </s:form>
                </div>
            </div>
        </div>
    </div>
</s:if>

<s:if test='%{#session.userTyp == ("D")}'>
    <s:form action="editExam" method="GET">
        <s:hidden name="examId" value="%{exam.id}"/>
        <s:submit value="editieren" type="button" class="btn btn-secondary"/>
    </s:form>

    <s:form action="removeExam" method="GET">
        <s:hidden name="examId" value="%{exam.id}"/>
        <s:submit value="löschen" type="button" class="btn btn-danger"/>
    </s:form>
</s:if>




