package de.nordakademie.multiplechoice.exam.service;

import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.model.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daniel Fiolka on 07.11.2017.
 */
@Service
public class ExamService {

    private final ExamRepository examRepository;

    @Autowired
    public ExamService(final ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Transactional(readOnly = true)
    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    @Transactional
    public void create(final Exam exam) {
        examRepository.create(exam);
    }

    @Transactional
    public Exam findOne(long examId){
        return examRepository.findOne(examId);
    }

}
