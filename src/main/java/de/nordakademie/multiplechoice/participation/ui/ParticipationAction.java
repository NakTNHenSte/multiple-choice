package de.nordakademie.multiplechoice.participation.ui;

/**
 * Created by Steven on 19.11.2017.
 */
import com.opensymphony.xwork2.Action;
import de.nordakademie.multiplechoice.participation.model.Participation;
import de.nordakademie.multiplechoice.participation.service.ParticipationService;
import de.nordakademie.multiplechoice.user.model.User;
import de.nordakademie.multiplechoice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ParticipationAction implements Action{

    private final ParticipationService participationService;
    private final UserService userService;

    private List<User> students;
    private User student;

    private long examId;

    private Participation participation;

    @Autowired
    public ParticipationAction(final ParticipationService participationService, UserService userService){
        this.participationService = participationService;
        this.userService = userService;
    }

    public String saveParticipation(){

        Participation participation = new Participation();
        participationService.create(participation, examId, student.getId());

        return SUCCESS;
    }

    public String getForm() {
        students = userService.findStudents();
        return SUCCESS;
    }


    public Participation getParticipation(){return participation;}

    public void setParticipation(final Participation participation){this.participation = participation;}

    public void setStudent(User student) {
        this.student = student;
    }

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

    public User getStudent() {
        return student;
    }

    @Override
    public String execute(){
        return SUCCESS;
    }
}
