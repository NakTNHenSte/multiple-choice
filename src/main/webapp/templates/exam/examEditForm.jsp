<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 09/11/2017
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<s:include value="/templates/exam/examCreationForm.jsp"></s:include>


<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#confirmationModal">
Frage anlegen
</button>

<s:include value="/templates/question/questionList.jsp"></s:include>

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
            <s:form action="saveQuestion">
                <div class="modal-body">

                    <s:hidden name="examId" value="%{exam.id}"/>
                    <s:textfield name="question.questiontext" label="Fragentext"/>
                    <s:textfield name="question.numberofanswers" label="Anzahl Anwortmöglichkeiten"/>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Schließen</button>
                    <s:submit value="Bestätigen" type="button" class="btn btn-primary"/>
                </div>
            </s:form>
        </div>
    </div>
</div>

<s:include value="/templates/user/userList.jsp"></s:include>
