import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        // Okulumuzun öğrenci bilgilerini ve sınıflarını tutacak HashMap
        Map<String, String> students = new HashMap<>();

        // Öğrenci bilgilerini HashMap ekleme
        students.put("Furkan Özalp", "1-A");
        students.put("Berkay Serkan Batur", "2-A");
        students.put("Can Manay", "1-B");
        students.put("Ayşe Can Aslan", "2-B");
        students.put("Deniz Mevlüt Kaplan", "3-A");

        // Öğrencilerin adı 'an' ile biten kişilerin bilgilerini ve sınıflarını gösterme
        System.out.println("Adı 'an' harfleri ile biten öğrenciler");
        for (String studentName : students.keySet()) {
            String className = students.get(studentName);
            String[] names = studentName.split(" ");
            String firstName = names[0];
            String secondName = "";
            if (names.length > 1) {
                secondName = names[1];
            }
            if (firstName.endsWith("an") || secondName.endsWith("an")) {
                System.out.println("Öğrenci Adı: " + studentName);
                System.out.println("Sınıfı: " + className);
                System.out.println("--------------------------");
            }
        }
    }
}
