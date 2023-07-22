package main;

import java.util.ArrayList;

public class Transcript {
    //Transkript için nitelikler yazıldı
    private int studentId;

    private ArrayList<CourseGrade> courses;

    private double GPA;
    //StudentId olmadan transkript oluşturulamaması için constructor oluşturuldu
    public Transcript(int studentId) {
        this.studentId = studentId;
        this.GPA = 0.0;
        this.courses = new ArrayList<>();
    }
    //GPA hesaplama yapıldı
    public void calculateGPA(){
        double totalGPA = 0;
        double totalCredit = 0;
        //öğrenciye kayıtlı kurslar döndürüldü
        for(CourseGrade grades: courses){
            //her bir kurs için kursun kredisi ile notu baz alınarak toplam not hesaplandı
            totalGPA += grades.getGradeTaken().getNumericValue() * grades.getCourseCredit();
            //toplam kredi hesaplandı
            totalCredit += grades.getCourseCredit();
        }
        //toplam not, toplam krediye bölünerek genel ortalama bulundu
        this.GPA = totalGPA/totalCredit;
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
        String courseStr = courses.toString();
        courseStr = courseStr.replace(",", "");
        courseStr = courseStr.replace("[", "");
        courseStr = courseStr.replace("]", "");
        return  "Student Id: " + studentId +
                courseStr + "\n" +
                "GPA=" + Math.round(GPA * 10.0)/10.0;
    }
}
