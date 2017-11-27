<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 09/11/2017
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<div class="row">
    <div class="col">
        <s:include value="/templates/exam/examCreationForm.jsp"></s:include>
    </div>
    <div class="col">
        <s:include value="/templates/participation/participantsList.jsp"></s:include>
    </div>
</div>
<table>
<tr>
<div class="row">
    <div class="col">
        <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#confirmationModal">
            Frage anlegen
        </button></td>
        <td><s:form action="saveBlankText">
            <s:hidden name="examId" value="%{examId}"/>
            <s:submit value="Lückentext anlegen" type="button" class="btn btn-secondary"/>
        </s:form></td>
        <s:include value="/templates/question/questionList.jsp"></s:include>
    </div>
</div>
</tr>
</table>
<div class="modal fade" id="confirmationModal" tabindex="-1" role="dialog" aria-labelledby="confirmationModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmationModalLabel">Frage hinzufügen</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <s:form action="saveQuestion">
                <div class="modal-body">

                    <s:hidden name="examId" value="%{exam.id}"/>
                    <s:textfield name="question.questionText" label="Fragentext"/>
                    <s:select label="Antwortanzahl auswählen"
                              headerKey="-1"
                              list="#{'1':'1', '2':'2', '3':'3', '4':'4', '5':'5', '6':'6', '7':'7', '8':'8', '9':'9'}"
                              name="answerCount"
                              value="1" />
                </div>
                <div class="modal-footer">
                    <s:submit value="Bestätigen" type="button" class="btn btn-primary"/>
                </div>
            </s:form>
        </div>
    </div>
</div>

