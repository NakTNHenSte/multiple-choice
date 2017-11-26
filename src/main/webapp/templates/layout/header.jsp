<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">

        <a href="/examList" class="navbar-brand"><i class="fa fa-check-square-o" aria-hidden="true"></i>
            Multiple Choice</a>

        <div class="navbar-right">
            <s:a action="userList">
                ${sessionScope.userFullName}
            </s:a>
            <button class="fa fa-sign-out fa-2x" data-toggle="modal" data-target="#confirmationModal2" aria-hidden="true">
            </button>
        </div>

    </div>
    <!-- Modal -->
    <div class="modal fade" id="confirmationModal2" tabindex="-1" role="dialog" aria-labelledby="confirmationModalLabel2"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmationModalLabel2">Abmeldevorgang bestätigen</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Sind Sie sicher, dass Sie sich abmelden wollen?
                </div>
                <div class="modal-footer">
                    <s:form action="logout">
                        <s:submit value="Abmelden" type="button" class="btn btn-primary"/>
                    </s:form>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Abbrechen</button>
                </div>
            </div>
        </div>
    </div>
</nav>