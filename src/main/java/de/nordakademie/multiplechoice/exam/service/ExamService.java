package de.nordakademie.multiplechoice.exam.service;

import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.model.ExamRepository;
import de.nordakademie.multiplechoice.participation.model.Participation;
import de.nordakademie.multiplechoice.participation.model.ParticipationRepository;
import de.nordakademie.multiplechoice.participation.service.ParticipationService;
import de.nordakademie.multiplechoice.user.model.User;
import de.nordakademie.multiplechoice.user.model.UserRepository;
import de.nordakademie.multiplechoice.user.service.UserService;
import de.nordakademie.multiplechoice.user.ui.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Fiolka on 07.11.2017.
 */
@Service
public class ExamService {

    private final ExamRepository examRepository;
    private UserService userService;
    private ParticipationRepository participationRepository;

    @Autowired
    public ExamService(final ExamRepository examRepository, UserService userService, ParticipationRepository participationRepository) {
        this.examRepository = examRepository;
        this.userService = userService;
        this.participationRepository = participationRepository;
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
    public Exam findOne(final long examId) {
        return examRepository.findOne(examId);
    }

    @Transactional
    public void removeExam(final long examId) {
        Exam exam = examRepository.findOne(examId);
        examRepository.remove(exam);
    }

    @Transactional
    public void update(Exam exam) {
        examRepository.update(exam);
    }

    @Transactional
    public List<Exam> findByUser(long userId) {

        List<Exam> exams = new ArrayList<>();
        User user = userService.find(userId);

        if (user.getType().equals(UserType.D.name())) {
            exams = examRepository.findByUser(userId);
        } else if (user.getType().equals(UserType.S.name())) {
            List<Participation> participations = participationRepository.findByUser(userId);
            for (Participation participation : participations) {
                exams.add(participation.getExam());
            }
        }
        return exams;
    }
}
