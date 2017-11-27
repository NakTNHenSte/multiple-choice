package de.nordakademie.multiplechoice.participation.service;

/**
 * Created by Daniel Fiolka on 26.11.17.
 * Dieser Enum enthält Konstanten für die möglichen Zustände eines Prüfungsergebnis bezüglich
 * einer Teilnahme oder auch nicht Teilnahme an einer Prüfung.
 */
public enum ExamResultEnum {

    PASSED("Bestanden"),
    FAILED("Nicht bestanden"),
    NOT_PARTICIPATED("Nicht teilgenommen");

    private ExamResultEnum(String examResult) {
        this.examResult = examResult;
    }

    private String examResult;

    public String getExamResult() {
        return this.examResult;
    }

    public String toString() {
        return this.examResult;
    }
}
