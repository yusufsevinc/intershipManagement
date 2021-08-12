package com.intership.internshipmanagement.enums;

public enum Situations {
    started(0),
    waiting(1),
    finished(2);
    private int situations;
    Situations(int situations) {
        this.situations = situations;
    }

    public int getSituations() {
        return situations;
    }

}
