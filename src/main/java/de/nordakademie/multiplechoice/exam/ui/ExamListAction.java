package de.nordakademie.multiplechoice.exam.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.participation.model.Participation;
import de.nordakademie.multiplechoice.participation.service.ParticipationService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExamListAction implements Action, SessionAware {


    private Exam exam;
    private Map<String, Object> sessionMap;
    private ParticipationService participationService;
    private List<Participation> participations;
    private List<Exam> exams = new ArrayList<Exam>();

    @Autowired
    public ExamListAction(final ParticipationService participationService) {
        this.participationService = participationService;
    }

    @Override
    public String execute() {

        participations = participationService.findByUser((long) sessionMap.get("userId"));
        for (Participation participation :participations){
            if(participation.getExamResult().equals("Nicht teilgenommen")){
                exams.add(participation.getExam());
            }
        }
        return SUCCESS;
    }


    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }


    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public List<Exam> getExams(){return exams;}
}
