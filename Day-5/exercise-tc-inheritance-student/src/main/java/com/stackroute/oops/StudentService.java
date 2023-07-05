package com.stackroute.oops;

public class StudentService {

    public Student createUnderGraduateStudent(int studentId, String name, double grade, int age, String address) {
        return new UnderGraduate(studentId, name, grade, age, address);
    }

    public Student createPostGraduateStudent(int studentId, String name, double grade, int age, String address) {
        return new PostGraduate(studentId, name, grade, age, address);
    }
}
