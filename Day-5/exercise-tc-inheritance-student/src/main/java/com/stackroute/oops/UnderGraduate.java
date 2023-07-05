package com.stackroute.oops;

/*
This is a subclass of Student class
 */
public class UnderGraduate extends Student {

    public UnderGraduate(int studentId, String name, double grade, int age, String address) {
        super(studentId, name, grade, age, address);
    }

    @Override
    public String toString() {
        return super.toString() + " Passed=" + isPassed(getGrade());
    }

    public boolean isPassed(double grade) {
        return grade > 70.0;
    }
}
