package de.nordakademie.multiplechoice.exam.ui;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.answer.service.AnswerService;
import de.nordakademie.multiplechoice.exam.model.Exam;
import de.nordakademie.multiplechoice.exam.service.ExamService;
import de.nordakademie.multiplechoice.participation.model.Participation;
import de.nordakademie.multiplechoice.participation.service.ParticipationService;
import de.nordakademie.multiplechoice.question.model.Question;
import de.nordakademie.multiplechoice.question.service.QuestionService;
import de.nordakademie.multiplechoice.testAnswer.model.TestAnswer;
import de.nordakademie.multiplechoice.testAnswer.service.TestAnswerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ExamExecutionAction extends ActionSupport implements Preparable {


    private final ExamService examService;
    private Exam exam;
    private long examId;
    private long userId;
    private String oneTimePassword;
    private ParticipationService participationService;
    private List<Question> questions;
    private QuestionService questionService;
    private Question question;
    private int currentQuestionIndex;
    private List<Answer> answerList;
    private AnswerService answerService;
    private int answerCount;
    private List<String> givenAnswers = new ArrayList<>();
    private TestAnswerService testAnswerService;
    private final String startRegex = "_%";
    private final String endRegex = "%_";


    @Autowired
    public ExamExecutionAction(final ExamService examService, ParticipationService participationService, QuestionService questionService, AnswerService answerService, TestAnswerService testAnswerService) {
        this.examService = examService;
        this.participationService = participationService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.testAnswerService = testAnswerService;
    }

    @Override
    public String execute() {
        loadQuestions();
        loadCurrentQuestion();
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
    }

    private void loadQuestions() {
        exam = examService.findOne(this.getExamId());
        questions = questionService.findByExam(exam.getId());
    }

    private void loadCurrentQuestion() {
        question = questions.get(currentQuestionIndex);
        String questionText = formatQuestion(question.getQuestionText());
        question.setQuestionText(questionText);
        answerList = answerService.findAll(question.getId());
        answerCount = answerList.size();


        for (int i = 0; i < answerCount; i++) {
            TestAnswer testAnswer = testAnswerService.findByAnswerId(answerList.get(i).getAnswerID());
            if (testAnswer == null) {
                givenAnswers.add("");
            } else {
                givenAnswers.add(testAnswer.getStudentAnswer());
            }
        }
    }

    public String nextQuestion() {
        loadQuestions();

        if (questions.size() > currentQuestionIndex + 1) {
            currentQuestionIndex++;
        }
        loadCurrentQuestion();
        return SUCCESS;
    }

    public String previousQuestion() {
        loadQuestions();

        if (0 < currentQuestionIndex) {
            currentQuestionIndex--;
        }
        loadCurrentQuestion();

        return SUCCESS;
    }

    public String runExam() {
        loadQuestions();
        currentQuestionIndex = 0;
        loadCurrentQuestion();

        Participation participation = participationService.findByUserIdAndExamId(userId, examId);

        if (isParticipationAllowed(participation)) {
            participation.setValid(true); // TODO: zu false ändern und in condition packen
            participationService.update(participation);
            return SUCCESS;
        } else {
            return INPUT;
        }
    }

    private String formatQuestion(String blankText) {
        int count = 1;
        while (blankText.contains(startRegex)) {
            int startGap = blankText.indexOf(startRegex);
            int endGap = blankText.indexOf(endRegex) + endRegex.length();
            String blank = blankText.substring(startGap, endGap);
            blankText = blankText.replaceFirst(blank, "| ____ |");
            count++;
        }
        return blankText;
    }

    private boolean isParticipationAllowed(Participation participation) {

        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        Date currentdate = new Date(System.currentTimeMillis());

        if (participation == null) {
            addActionError("Sie sind nicht als Teilnehmer dieser Prüfung eingetragen.");
            return false;
        }
        ;
        if (!participation.getOneTimePassword().equals(oneTimePassword)) {
            addActionError("Das Passwort stimmt nicht.");
            return false;
        }
        ;
        if (!participation.isValid()) {
            addActionError("Ihr Zugang wurde bereits benutzt und ist abgelaufen.");
            return false;
        }
        ;
        if (!exam.getEnd().after(currentTimestamp) || exam.getStart().after(currentTimestamp)) {
            addActionError("Die Anmeldung muss während des Prüfungszeitraums erfolgen.");
            return false;
        }

        return true;
    }

    public String participate() {
        // TODO: DIESE METHODE ENTFERNEN
        loadQuestions();
        loadCurrentQuestion();

        /**
         * Hier muss noch das Speichern der gegebenen Antworten rein. Das geht jedoch erst,
         * wenn wir die Tabelle dazu besprochen und erstellt haben.
         */

        //TODO: anpassen an das Antwortenattribut der Studenten-Klasse (die es noch nicht gibt)
        for (String answer : givenAnswers) {

        }
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


    public String getOneTimePassword() {
        return oneTimePassword;
    }

    public void setOneTimePassword(String oneTimePassword) {
        this.oneTimePassword = oneTimePassword;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public void setGivenAnswers(List<String> givenAnswers) {
        this.givenAnswers = givenAnswers;
    }

    public List<String> getGivenAnswers() {
        return givenAnswers;
    }

}
