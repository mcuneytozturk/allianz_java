package util;

public class GradeTest {
    //GradeTest sınıfından Grades çağrılcak metod oluşturuldu
    public void values(){
        //enum değerleri values() ile bir dizi olarak çağrılıp dizinin elemanları forEach metodu ile yazdırıldı
        for (Grade value: Grade.values()){
            System.out.println(value);
        }
    }
}
