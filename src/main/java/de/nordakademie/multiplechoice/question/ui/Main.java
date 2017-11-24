package de.nordakademie.multiplechoice.question.ui;

import de.nordakademie.multiplechoice.answer.model.Answer;
import de.nordakademie.multiplechoice.answer.service.AnswerService;
import de.nordakademie.multiplechoice.question.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 22.11.17.
 */
public class Main {

    public static void main(String[] args) {

        QuestionFillTheBlankTextAction action = new QuestionFillTheBlankTextAction(null, null);

        List<String> answers = new ArrayList<String>();

//        answers = action.extractAnswers("Dies ist ein $$guter%% Probetext. Und dann ist er " +
//                "noch schön $$kurz%%.");
//
//
//        for (String answer : answers) {
//            System.out.println(answer);
//        }

    }

}
