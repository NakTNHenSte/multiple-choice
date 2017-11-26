package de.nordakademie.multiplechoice.testAnswer.service;

public enum CorrectnessEnum {

    CORRECT("CORRECT"),
    MISSING("MISSING"),
    WRONG("WRONG");

    private CorrectnessEnum(String correctness) {
        this.correctness = correctness;
    }

    private String correctness;

    public String getCorrectness() {
        return this.correctness;
    }

    public String toString() {
        return this.correctness;
    }
}
