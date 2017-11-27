package de.nordakademie.multiplechoice.participation.ui;

/**
 * Created by Steven on 12.11.2017.
 */
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import de.nordakademie.multiplechoice.participation.model.Participation;
import de.nordakademie.multiplechoice.participation.service.ExamResultEnum;
import de.nordakademie.multiplechoice.participation.service.ParticipationService;
import de.nordakademie.multiplechoice.user.model.User;
import de.nordakademie.multiplechoice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ParticipationAction extends ActionSupport implements Preparable{

    private final ParticipationService participationService;
    private final UserService userService;

    private List<User> students;
    private Long user;
    private long participationId;


    private long examId;

    private Participation participation;

    @Autowired
    public ParticipationAction(final ParticipationService participationService, UserService userService){
        this.participationService = participationService;
        this.userService = userService;
    }

    /** Diese Methode speichert eine Participation bzw. eine Prüfungsteilnahme.
     * @return
     */
    public String saveParticipation(){

        Participation participation = new Participation();
        participation.setExamResult(ExamResultEnum.NOT_PARTICIPATED.getExamResult());
        participation.setValid(true);
        participationService.create(participation, examId, user);

        return SUCCESS;
    }

    public String getForm() {
        List<Participation> particis = new ArrayList<>(participationService.findAll(examId));
        Set<User> studentsToRemove = new HashSet<>();
        for (Participation each : particis) {
            studentsToRemove.add(each.getUser());
        }

        students.removeAll(studentsToRemove);
        return SUCCESS;
    }


    public Participation getParticipation(){return participation;}

    public void setParticipation(final Participation participation){this.participation = participation;}

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }


    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    @Override
    public void prepare() throws Exception {
        students = userService.findStudents();

    }

    /**
     * Diese Methode löscht eine Teilnahme.
     */
    public String removeParticipation(){
        participationService.delete(participationId);
        return SUCCESS;
    }

    public void setParticipationId(long participationId) {
        this.participationId = participationId;
    }

    public long getParticipationId(){
        return participationId;
    }
}
