package de.nordakademie.multiplechoice.exam.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExamListAction implements Action {


    private final ExamService examService;

    private List<Exam> exams;

    @Autowired
    public ExamListAction(final ExamService examService) {
        this.examService = examService;
    }

    @Override
    public String execute() {
        exams = examService.findAll();
        return SUCCESS;
    }

    public List<Exam> getExams() {
        return exams;
    }

}
