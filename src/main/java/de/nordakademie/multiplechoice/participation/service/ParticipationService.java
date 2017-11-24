package de.nordakademie.multiplechoice.participation.service;

import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.service.ExamService;
import de.nordakademie.multiplechoice.participation.model.Participation;
import de.nordakademie.multiplechoice.participation.model.ParticipationRepository;
import de.nordakademie.multiplechoice.question.model.QuestionRepository;
import de.nordakademie.multiplechoice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daniel Fiolka on 23.11.17.
 */
@Service
public class ParticipationService {

    private final ParticipationRepository participationRepository;
    private final QuestionRepository questionRepository;
    private final ExamService examService;
    private final UserService userService;


    @Autowired
    public ParticipationService(final ParticipationRepository participationRepository, final QuestionRepository questionRepository, ExamService examService, UserService userService) {
        this.participationRepository = participationRepository;
        this.questionRepository = questionRepository;
        this.examService = examService;
        this.userService = userService;
    }

    @Transactional(readOnly = true)
    public List<Participation> findAll(long examId) {
        return participationRepository.findAll(examId);
    }

    @Transactional
    public void create(final Participation participation, long examId, long userId) {
        OneTimePasswordGenerator pwgen = new OneTimePasswordGenerator();
        participation.setOneTimePassword(pwgen.generatePassword());
        participation.setExam(examService.findOne(examId));
        participation.setUser(userService.find(userId));

        participationRepository.create(participation);
    }

    @Transactional
    public void delete(final long participationId) {
        Participation participation = participationRepository.findOne(participationId);
        participationRepository.delete(participation);
    }

    @Transactional
    public Participation findOne(final long participationID) {
        final Participation participation = participationRepository.findOne(participationID);
        return participation;
    }

    @Transactional
    public void deleteExam(long examId) {
        List<Participation> participations = participationRepository.findAll(examId);
        for (Participation participation : participations) {
            participationRepository.delete(participation);
        }
    }

    @Transactional
    public void update(Participation participation) {
        participationRepository.update(participation);
    }

    @Transactional
    public Participation findByUserIdAndExamId(long userId, long examId) {
        return participationRepository.findByUserIdAndExamId(userId, examId);
    }
}