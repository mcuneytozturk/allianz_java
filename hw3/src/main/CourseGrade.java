package main;

import util.Grade;

public class CourseGrade {

    private String courseDepartment = "CENG";

    private int courseCode = 100;

    private int courseCredit = 4;

    private Grade gradeTaken = Grade.F;

    public CourseGrade() {
    }

    public CourseGrade(String courseDepartment) {
        this.courseDepartment = courseDepartment;
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        this.courseDepartment = courseDepartment;
        this.courseCode = courseCode;
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this.courseDepartment = courseDepartment;
        this.courseCode = courseCode;
        this.courseCredit = courseCredit;
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        this.courseDepartment = courseDepartment;
        this.courseCode = courseCode;
        this.courseCredit = courseCredit;
        this.gradeTaken = gradeTaken;
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(String courseDepartment) {
        if (courseDepartment.length() == 4) {
            this.courseDepartment = courseDepartment;
        } else {
            System.err.println("Lütfen ders kodunu 4 haneli olacak şekilde giriniz!");
        }
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        if (courseCode > 100 && courseCode < 590) {
            this.courseCode = courseCode;
        } else {
            System.err.println("Ders kodu 101 ile 590 arasında bir değer almalıdır!*");
        }
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    public void setGradeTaken(double val) {
        if (val >= 0 && val <= 4) {
            for (Grade grade: Grade.values()){
                if (grade.getNumericValue() == Math.round(val)){
                    this.gradeTaken = grade;
                }
            }
        }
    }

    public void setGradeTaken(Grade g){
        this.gradeTaken = g;
    }

    @Override
    public String toString() {
        return "Department: " + courseDepartment + " Course Code: " + courseCode + " Credit: " + courseCredit + " Grade: " + gradeTaken.getStringValue() + "\n";
    }
}

