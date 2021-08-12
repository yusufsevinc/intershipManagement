package com.intership.internshipmanagement.enums;

public enum Degree {

    undergraduate(0),
    graduate(1),
    doctorate(2);
    private int degree;
    Degree(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }


}
