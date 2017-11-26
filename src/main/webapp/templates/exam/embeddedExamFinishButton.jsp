<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 26/11/2017
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div align="right">
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#confirmationModal">
        Prüfung beenden
    </button>
</div>
<!-- Modal -->
<div class="modal fade" id="confirmationModal" tabindex="-1" role="dialog" aria-labelledby="confirmationModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmationModalLabel">Prüfungsbeendigung bestätigen</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Sind Sie sicher, dass Sie die Prüfung beenden wollen?
            </div>
            <div class="modal-footer">
                <s:form action="finishExam">
                    <s:hidden name="examId" value="%{examId}"/>
                    <s:submit value="Bestätigen" type="button" class="btn btn-primary"/>
                </s:form>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Abbrechen</button>
            </div>
        </div>
    </div>
</div>
