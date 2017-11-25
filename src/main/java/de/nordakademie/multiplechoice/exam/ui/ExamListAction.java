package de.nordakademie.multiplechoice.exam.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.service.ExamService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class ExamListAction implements Action, SessionAware {


    private final ExamService examService;
    private Exam exam;
    private List<Exam> exams;
    private Map<String, Object> sessionMap;

    @Autowired
    public ExamListAction(final ExamService examService) {
        this.examService = examService;
    }

    @Override
    public String execute() {
     //   if(sessionMap.get("userTyp") == "S")
        exams = examService.findAll();
        return SUCCESS;
    }

    public List<Exam> getExams() {
        return exams;
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


}
