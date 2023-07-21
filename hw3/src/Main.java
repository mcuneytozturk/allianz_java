
import main.CourseGrade;
import main.Transcript;
import util.Grade;
import util.GradeTest;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        GradeTest grades = new GradeTest();
        grades.values();

        CourseGrade courseGrade1 = new CourseGrade();
        courseGrade1.setCourseDepartment("MAT1");
        courseGrade1.setCourseCode(102);
        courseGrade1.setCourseCredit(4);
        courseGrade1.setGradeTaken(3.5);

        System.out.println(courseGrade1);

        CourseGrade courseGrade2 = new CourseGrade();
        courseGrade2.setGradeTaken(Grade.B);

        System.out.println(courseGrade2);

        Transcript transcript = new Transcript(1112234);

        transcript.addCourseTaken(courseGrade1);
        transcript.addCourseTaken(courseGrade2);

        System.out.println(transcript);


    }
}