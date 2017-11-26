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

<table>
    <tr>
        <div class="row">
            <div class="col"><b>Id: </b><s:property value="exam.id"/></div>
        </div>
        <div class="row">
            <div class="col"><b>Titel: </b><s:property value="exam.title"/></div>
        </div>
        <div class="row">
            <div class="col"><b>Dozent: </b><s:property value="exam.user.name"/> <s:property value="exam.user.surname"/>
            </div>
        </div>
        <div class="row">
            <div class="col"><b>Seminar: </b><s:property value="exam.seminar"/></div>
        </div>
        <div class="row">
            <div class="col"><b>Credits: </b><s:property value="exam.credits"/></div>
        </div>
        <div class="row">
            <div class="col"><b>Prüfungszeitraum: </b><s:property value="exam.start"/> - <s:property value="exam.end"/>
            </div>
        </div>
        <div class="row">
            <div class="col"><b>Bestehensgrenze: </b><s:property
                    value="exam.percentualSuccessThreshold"/> %
            </div>
        </div>
        <div class="row">
            <div class="col"><b>Dauer: </b><s:property value="exam.duration"/> Minuten</div>
        </div>
        <br>
        <s:if test="hasActionErrors()">
            <div class="alert alert-danger" role="alert">
                <s:actionerror/>
            </div>
        </s:if>

        <s:if test='%{#session.userType == ("D")}'>
        <td>
            <s:form action="editExam">
                <s:hidden name="examId" value="%{exam.id}"/>
                <s:submit value="editieren" type="button" class="btn btn-secondary"/>
            </s:form>
        </td>
        <td>
            <s:form action="removeExam">
                <s:hidden name="examId" value="%{exam.id}"/>
                <s:submit value="löschen" type="button" class="btn btn-danger"/>
            </s:form>
        </td>
    </tr>
    <tr>
        <table class="table table-sm">
            <tr>
                <th>Name</th>
                <th>Nachname</th>
                <th>Einmalpasswort</th>
                <th>Gültigkeit des PW</th>
            </tr>
            <s:iterator value="participations">
                <tr>
                    <td><s:property value="user.name"/></td>
                    <td><s:property value="user.surname"/></td>
                    <td><s:property value="oneTimePassword"/></td>
                    <td><s:property value="valid"/></td>
                </tr>
            </s:iterator>
        </table>
    </tr>
    </s:if>

</table>


<s:if test='%{#session.userType == ("S")}'>
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
                    Bitten geben Sie ihr vom Dozenten erhaltenes Einmalpasswort ein, um die Prüfung zu starten. Beachten
                    Sie, dass dieses Passwort nur einmal gültig ist und die Bearbeitungszeit mit dieser Anmeldung
                    beginnt.
                </div>
                <div class="modal-footer">
                    <s:form action="startExam">
                        <s:hidden name="examId" value="%{exam.id}"/>
                        <s:hidden name="userId" value="%{#session.userId}"/>

                        <s:textfield name="oneTimePassword" label="Einmalpasswort"/>
                        <s:submit value="Prüfung starten" type="button" class="btn btn-primary"/>
                    </s:form>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Abbrechen</button>

                </div>
            </div>
        </div>
    </div>
</s:if>





