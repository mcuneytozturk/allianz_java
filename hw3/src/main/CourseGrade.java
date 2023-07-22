package main;

import util.Grade;

public class CourseGrade {
    //hw3.pdf dosyasınde belirtilen işlemler için sınıf nitelikleri yazıldı

    private String courseDepartment;

    private int courseCode;

    private int courseCredit;

    private Grade gradeTaken;

    //setter ile nitelik girebilmek için boş constructor oluşturuldu
    public CourseGrade() {
    }

    //courseDepartment belirtilmesi için koşullu ve diğer default değerler için bir constructor yazıldı
    public CourseGrade(String courseDepartment) {
        //kurs departmanı ismi 4 haneli olmalıdır yoksa hata yazdırılır ve default değer ataması yapılır
        if (courseDepartment.length() == 4) {
            this.courseDepartment = courseDepartment;
        } else {
            this.courseDepartment = "CENG";
            System.err.println(courseDepartment + "!!\t Lütfen ders kodunu 4 haneli olacak şekilde girilmez ise 'CENG' kodu ataması yapılır!");
        }
    }

    //courseDepartment zincirlendi ve courseCode için koşullu kalan değerler için default bir constructor yazıldı
    public CourseGrade(String courseDepartment, int courseCode) {
        this(courseDepartment);
        //kurs kodu 100 ve 599 arası bir değer almalıdır farklı değer alması durumunda hata yazdırılır ve default değer ataması yapılır
        if (courseCode > 100 && courseCode < 599) {
            this.courseCode = courseCode;
        } else {
            this.courseCode = 100;
            System.err.println(this.courseDepartment + ":\t" + courseCode + "!!\t Ders kodu için 101 ile 599 arasında bir değer girilmez ise otomatik olarak 100 atanır!");
        }
        this.courseCredit = 4;
        this.gradeTaken = Grade.F;
    }

    //courseDepartment ve courseCode zincirlendi, courseCredit koşullandı kalan değerler için default bir constructor yazıldı
    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this(courseDepartment, courseCode);
        //kurs kredisi 3 veya 4 değeri almalıdır aksi takdirde hata yazdırılır ve default 4  değeri atanır
        if (courseCredit == 3 || courseCredit == 4) {
            this.courseCredit = courseCredit;
        } else {
            this.courseCredit = 4;
            System.err.println(this.courseDepartment + ":\t" +courseCredit + "!!\t Ders kredisi sadece 3 veya 4 değeri alabilir");
        }
        this.gradeTaken = Grade.F;
    }

    //courseDepartment, courseCode ve courseCredit zincirlendi, gradeTaken koşullandı
    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        this(courseDepartment, courseCode, courseCredit);

        //kurs notu enum değeri almalıdır aksi takdirde hata yazdırılır, hatada yönlendirme yapılır ve default F notu girilir
        for (Grade grade : Grade.values()) {
            if (gradeTaken == grade) {
                this.gradeTaken = gradeTaken;
            } else {
                this.gradeTaken = Grade.F;
                System.err.println(this.courseDepartment + ":\t" +gradeTaken+ "!!\t Ders notu Grade olarak girilmelidir, not girilmek isteniyorsa manuel(setGradeTaken() metodu) olarak girilmelidir");
            }
        }
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(String courseDepartment) {
        if (courseDepartment.length() == 4) {
            this.courseDepartment = courseDepartment;
        } else {
            this.courseDepartment = "CENG";
            System.err.println(courseDepartment + "!!\t Lütfen ders kodunu 4 haneli olacak şekilde girilmez ise 'CENG' kodu ataması yapılır!");
        }
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        if (courseCode > 100 && courseCode < 599) {
            this.courseCode = courseCode;
        } else {
            this.courseCode = 100;
            System.err.println(this.courseDepartment + ":\t" +courseCode + "!!\t Ders kodu için 101 ile 599 arasında bir değer girilmez ise otomatik olarak 100 atanır!");
        }
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        if (courseCredit == 3 || courseCredit == 4) {
            this.courseCredit = courseCredit;
        } else {
            this.courseCredit = 4;
            System.err.println(this.courseDepartment + ":\t" +courseCredit + "!!\t Ders kredisi için 3 veya 4 değeri girilmez ise ders kredisi 4 kabul edilir");
        }
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    //sayısal not girilmesi durumunda bu notun String değerini atayan metod yazıldı
    public void setGradeTaken(double val) {
        if (val >= 0 && val <= 4) {
            for (Grade grade : Grade.values()) {
                if (grade.getNumericValue() == Math.round(val)) {
                    this.gradeTaken = grade;
                }
            }
        }
    }

    //Harf notu girilmesi için metod yazıldı
    public void setGradeTaken(Grade g) {
        this.gradeTaken = g;
    }

    @Override
    public String toString() {
        return "\n\t" + "Department: " + courseDepartment.toUpperCase() + " Course Code: " + courseCode + " Credit: " + courseCredit + " Grade: " + gradeTaken.getStringValue();
    }
}

