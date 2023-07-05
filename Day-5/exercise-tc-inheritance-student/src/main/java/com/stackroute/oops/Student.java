package com.stackroute.oops;

/**
 * This abstract class has five fields - studentId, name, grade, age and address.
 */
public abstract class Student {
    private int studentId;
    private String name;
    private double grade;
    private int age;
    private String address;

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    /*
    Parameterized constructor for initializing fields
     */
    public Student(int studentId, String name, double grade, int age, String address) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.age = age;
        this.address = address;
    }

    /*
    Overridden toString() method for string representation of Student object
     */
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    /*
    Abstract method to be implemented by sub classes
     */
    public abstract boolean isPassed(double grade);
}
