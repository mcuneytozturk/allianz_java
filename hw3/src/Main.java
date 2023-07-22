
import main.CourseGrade;
import main.Transcript;
import util.Grade;
import util.GradeTest;

public class Main {
    public static void main(String[] args) {

        //
        GradeTest grades = new GradeTest();
        grades.values();

        CourseGrade courseGrade1 = new CourseGrade();
        courseGrade1.setCourseDepartment("MAT132");
        courseGrade1.setCourseCode(101);
        courseGrade1.setCourseCredit(4);
        courseGrade1.setGradeTaken(3.5);

        CourseGrade courseGrade2 = new CourseGrade("MBG2", 580);
        courseGrade2.setGradeTaken(Grade.D);
        courseGrade2.setCourseCredit(4);

        CourseGrade courseGrade3 = new CourseGrade("CHeM");
        courseGrade3.setCourseCode(611);
        courseGrade3.setGradeTaken(Grade.A);
        courseGrade3.setCourseCredit(3);


        Transcript transcript = new Transcript(1112234);
        transcript.addCourseTaken(courseGrade1);
        transcript.addCourseTaken(courseGrade2);
        transcript.addCourseTaken(courseGrade3);

        System.out.println(transcript);


    }
}