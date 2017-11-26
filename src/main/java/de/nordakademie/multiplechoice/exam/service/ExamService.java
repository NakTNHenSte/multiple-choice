package de.nordakademie.multiplechoice.exam.service;

import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.model.ExamRepository;
import de.nordakademie.multiplechoice.participation.model.Participation;
import de.nordakademie.multiplechoice.participation.model.ParticipationRepository;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.model.QuestionRepository;
import de.nordakademie.multiplechoice.user.model.User;
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
    private QuestionRepository questionRepository;

    @Autowired
    public ExamService(final ExamRepository examRepository, UserService userService, ParticipationRepository participationRepository, QuestionRepository questionRepository) {
        this.examRepository = examRepository;
        this.userService = userService;
        this.participationRepository = participationRepository;
        this.questionRepository = questionRepository;
    }

    /**
     * Ruft das ExamRepository auf um alle Exam Entitäten zurückzugeben.
     * @return alle Exam Entitäten aus der Datenbank.
     */
    @Transactional(readOnly = true)
    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    /**
     * Diese Methode übergibt dem ExamRepository ein Exam um dieses
     * in der Datenbank zu erschaffen.
     * @param exam ist die zu erschaffende Exam Entität.
     */
    @Transactional
    public void create(final Exam exam) {
        examRepository.create(exam);
    }

    /**
     * Ruft das ExamRepository auf um ein Exam anhand einer examId zu finden.
     * @param examId die Id der Prüfung die gefunden werden sollen.
     * @return gibt ein Exam zurück.
     */
    @Transactional
    public Exam findOne(final long examId) {
        return examRepository.findOne(examId);
    }

    /**
     * Ruft das ExamRepository auf um ein Exam aus der Datenbank zu löschen.
     * @param examId ist die Id des zu entfernenden Exams.
     */
    @Transactional
    public void removeExam(final long examId) {
        Exam exam = examRepository.findOne(examId);
        examRepository.remove(exam);
    }

    /**
     * Ruft das ExamRepository auf um ein Exam in der Datenbank zu aktualisieren.
     * @param exam ist das Exam mit den aktualisierten Werten.
     */
    @Transactional
    public void update(Exam exam) {
        examRepository.update(exam);
    }

    /**
     * Ruft das ExamRepository auf um anhand einer userId Exams zu finden.
     * @param userId die Id eines Users zu der die Exams gefunden werden sollen.
     * @return gibt eine Liste von Exams zurück.
     */
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

    /**
     * Gibt die maximal zu erreichende Punktzahl eines Exams zurück.
     * @param examId die Id der Prüfung.
     * @return die maximale Punktzahl.
     */
    @Transactional
    public double getMaximumPointsInExam(long examId) {
        double maximumPoints = 0;
        List<Question> questions = questionRepository.findByExam(examId);

        for (Question question : questions) {
            maximumPoints = maximumPoints + question.getScorePerCorrectChoice();
        }
        return maximumPoints;
    }
}
