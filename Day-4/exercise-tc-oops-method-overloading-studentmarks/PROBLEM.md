## Problem Statement: Writing unit test cases for the given solution ##

**This exercise should be completed by writing unit test cases for the solution provided**


- Below is the summary of the solution provided

- class StudentMarks contains the following overloaded methods :

           +calculateMarks(int physics, int chemistry, int maths)                               : int
                -Shounld add all marks and return integer 
           +calculateMarks(int physics, int chemistry, int maths, int bio)                       : int
                -Should add all marks and return integer    
           +calculateMarks(double physics, double chemistry, double maths, double bio)           : double
                -Should add all marks and return double
           +calculateMarks(float maths, float bio, float physics, float chemistry, float lang)   : float
                -Should add all marks and return float
           +calculateMarks(ffloat maths, float bio, float physics, float chemistry)               : float
                 -Should add all marks and return float 
           +classifyStudentGrade(Set marksPercentSet)                                             : String
                 -Should return "GRADE A" if set contains 98 marks otherwise "not Grade A"
           +classifyStudentGrade(List marksPercentList)                                           : String
                -Should return "GRADE B" if list contains 80 marks otherwise "not Grade B"
           +classifyStudentGrade(Collection marksPercentCollection)                                                       : String
                 -Should return "GRADE C" if collection contains 70 marks otherwise "None"

- Create class StudentMarksTests in package com.stackroute.oops 
 
    - write the unit tests for testing the overloading of methods in the class

- Some of the test cases are mentioned below

    - CalculateMarks method called with 3 integer arguments
    - CalculateMarks method called with 4 integer arguments
    - CalculateMarks method called with 4 double arguments
    - CalculateMarks static method called  with 5 float arguments in different order
    - CalculateMarks method called  with 4 float arguments in different order
    - ClassifyStudentGrade method called with list 
    - ClassifyStudentGrade method called with set  
    - ClassifyStudentGrade method called with vector with the negative scenario
    

- Minimum test cases expected : 8


- Test cases should be written for positive, negative and boundary scenarios, wherever applicable


- Test coverage should be 100%



## Instructions

- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding