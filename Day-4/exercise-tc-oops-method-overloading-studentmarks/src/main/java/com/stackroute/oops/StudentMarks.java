package com.stackroute.oops;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class StudentMarks {

    /* adding 4 integer values.*/

    public int calculateMarks(int physics, int chemistry, int maths) {

        int sum = physics + chemistry + maths;
        return sum;
    }

    /* adding 3 integer values.*/
    public int calculateMarks(int physics, int chemistry, int maths, int bio) {

        int sum = physics + chemistry + maths + bio;
        return sum;
    }

    /* adding 4 double values.*/
    public double calculateMarks(double physics, double chemistry, double maths, double bio) {

        double sum = physics + chemistry + maths + bio;

        return sum;
    }

    /* static method adding 5 float values.*/
    public static float calculateMarks(float maths, float bio, float physics, float chemistry, float lang) {

        float sum = physics + chemistry + maths + bio + lang;

        return sum;
    }


    /* adding 4 float values with order changed.*/
    public float calculateMarks(float maths, float bio, float physics, float chemistry) {

        float sum = physics + chemistry + maths + bio;

        return sum;
    }

    /* classifyStudentGrade with Set as parameter.*/
    public static String classifyStudentGrade(Set<Integer> marksPercentSet) {

        if (marksPercentSet.contains(98))
            return "GRADE A";
        else return "not Grade A";
    }

    /* classifyStudentGrade with List as parameter.*/
    public static String classifyStudentGrade(List marksPercentList) {

        if (marksPercentList.contains(80))
            return "GRADE B";
        else
            return "not Grade B";
    }

    /* classifyStudentGrade with Collection as parameter.*/
    public static String classifyStudentGrade(Collection marksPercentCollection) {
        if (marksPercentCollection.contains(70))
            return "GRADE C";
        else
            return "None";
    }

}
