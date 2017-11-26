package de.nordakademie.multiplechoice.participation.service;

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
