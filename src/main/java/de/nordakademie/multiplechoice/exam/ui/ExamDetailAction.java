package de.nordakademie.multiplechoice.exam.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExamDetailAction implements Action {


    private final ExamService examService;

    private Exam exam;

    private long examId;

    @Autowired
    public ExamDetailAction(final ExamService examService) {
        this.examService = examService;
    }

    @Override
    public String execute() {
        exam = examService.findOne(this.getExamId());
        return SUCCESS;
    }

    public Exam getExam() {
        return exam;
    }

    public String getForm() {
        return SUCCESS;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }
}
