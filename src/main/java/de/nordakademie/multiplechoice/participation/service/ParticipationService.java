package de.nordakademie.multiplechoice.participation.service;

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

    /** Ruft das ParticipationRepository auf um alle Participation Entitäten zurückzugeben
     * @return eine Liste von participations.
     */
    @Transactional(readOnly = true)
    public List<Participation> findAll(long examId) {
        return participationRepository.findAll(examId);
    }

    /**
     * Diese Methode übergibt dem ParticipationRepository eine Participation um diese
     * in der Datenbank zu persistieren.
     * @param participation ist die zu erschaffende answer Entität.
     */
    @Transactional
    public void create(final Participation participation, long examId, long userId) {
        OneTimePasswordGenerator pwgen = new OneTimePasswordGenerator();
        participation.setOneTimePassword(pwgen.generatePassword());
        participation.setExam(examService.findOne(examId));
        participation.setUser(userService.find(userId));

        participationRepository.create(participation);
    }

    /**
     * Ruft das ParticipationRepository auf um eine Participation aus der Datenbank zu löschen.
     * @param participationId ist die Id der zu entfernenden participation.
     */
    @Transactional
    public void delete(final long participationId) {
        Participation participation = participationRepository.findOne(participationId);
        participationRepository.delete(participation);
    }

    /**
     * Ruft das ParticipationRepository auf um eine Participation aus der Datenbank zu finden.
     * @param participationID ist die Id der zu findenden Participation.
     */
    @Transactional
    public Participation findOne(final long participationID) {
        final Participation participation = participationRepository.findOne(participationID);
        return participation;
    }

    /**
     * Ruft das ParticipationRepository auf alle Particpations aus der Datenbank zu löschen, die
     * zu einem bestimmten Exam gehören.
     * @param examId ist die Id des bestimmten exams.
     */
    @Transactional
    public void deleteByExam(long examId) {
        List<Participation> participations = participationRepository.findAll(examId);
        for (Participation participation : participations) {
            participationRepository.delete(participation);
        }
    }

    /**
     * Findet mehrere Participations, die zu einem bestimmten user gehören.
     * @param userId die Id des bestimmten users.
     * @return eine Liste der gefundenen Participations.
     */
    @Transactional
    public List<Participation> findByUser(long userId){
        return participationRepository.findByUser(userId);
    }

    /**
     * Ruft das ParticipationRepository auf um eine Participation in der Datenbank zu aktualisieren.
     * @param participation ist die Participation mit den zu aktualisierenden Werten.
     */
    @Transactional
    public void update(Participation participation) {
        participationRepository.update(participation);
    }

    /**
     * Findet eine Particpation eines bestimmten Users und eines bestimmten Exams.
     * @param userId die Id des bestimmten users.
     * @param examId die Id des bestimmten exams.
     * @return die gefundene Participation.
     */
    @Transactional
    public Participation findByUserIdAndExamId(long userId, long examId) {
        return participationRepository.findByUserIdAndExamId(userId, examId);
    }

}