package de.nordakademie.multiplechoice.testAnswer.service;


/**
 * Created by Daniel Fiolka on 26.11.17.
 * Dieser Enumtyp enthält drei Konstanten, die die dreiteilige Antwortkorrektheitsbewertung
 * repräsentieren.
 */
public enum CorrectnessEnum {

    CORRECT("CORRECT"),
    MISSING("MISSING"),
    WRONG("WRONG");

    CorrectnessEnum(String correctness) {
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
