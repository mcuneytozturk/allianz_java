package main;

import java.util.ArrayList;

public class Transcript {

    private int studentId;

    private ArrayList<CourseGrade> courses;

    private double GPA;

    public Transcript(int studentId) {
        this.studentId = studentId;
        this.GPA = 0.0;
        this.courses = new ArrayList<>();
    }

    public void calculateGPA(){
        double totalGPA = 0;

        for(CourseGrade grades: courses){
            totalGPA += grades.getGradeTaken().getNumericValue();
        }

        this.GPA = totalGPA/courses.size();
    }

    public void addCourseTaken(CourseGrade courseGrade){
        if(courseGrade != null){
            this.courses.add(courseGrade);
            calculateGPA();
        } else {
            System.err.println("Böyle bir ders notu bulunamadı");
        }
    }

    @Override
    public String toString() {
        return  "Student Id: " + studentId + "\n" +
                courses.toString() + "\n" +
                "GPA=" + GPA;
    }
}
