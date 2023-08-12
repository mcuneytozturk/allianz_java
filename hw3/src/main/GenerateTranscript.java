package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenerateTranscript {
    public void takeInputFromUser(){
        Scanner sc = new Scanner(System.in);

        CourseGrade courseGrade = new CourseGrade();


        System.out.println(("Enter Student Id: "));
        int studentId = sc.nextInt();
        Transcript transcript = new Transcript(studentId);

        System.out.println(("Enter Department: "));
        String department = sc.nextLine();
        courseGrade.setCourseDepartment(department);
        System.out.println(("Enter Course Code: "));
        int courseCode = sc.nextInt();
        courseGrade.setCourseCode(courseCode);
        System.out.println(("Enter Course Credit: "));
        int courseCredit = sc.nextInt();
        courseGrade.setCourseCredit(courseCredit);
        System.out.println(("Enter Grade(Numeric value): "));
        double gradeTaken = sc.nextDouble();
        courseGrade.setGradeTaken(gradeTaken);

        transcript.addCourseTaken(courseGrade);
    }

    public void takeInputFromFile(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter filename: ");
        String fileName = sc.nextLine();
        Transcript transcript = new Transcript();

        File file = new File(fileName);
        try {
            sc = new Scanner(file);

            if (sc.hasNextLine()) {
                int studentId = sc.nextInt();
                transcript.setStudentId(studentId);
            }

            while (sc.hasNextLine()) {
                String nextLine = sc.nextLine();
                String[] dataList = nextLine.split(" ");

                if (dataList.length == 4) {
                    CourseGrade courseGrade = new CourseGrade();

                    String department = dataList[0];
                    courseGrade.setCourseDepartment(department);
                    int courseCode = Integer.parseInt(dataList[1]);
                    courseGrade.setCourseCode(courseCode);
                    int courseCredit = Integer.parseInt(dataList[2]);
                    courseGrade.setCourseCredit(courseCredit);
                    double grade = Double.parseDouble(dataList[3]);
                    courseGrade.setGradeTaken(grade);

                    transcript.addCourseTaken(courseGrade);
                }
            }
            sc.close();
            System.out.println(transcript);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
