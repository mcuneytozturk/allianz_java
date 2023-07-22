package util;

public enum Grade {

    //Grade'ler hem string hem sayısal olarak tanımlandı
    A("A", 4), B("B", 3), C("C", 2), D("D", 1), F("F", 0);

    private final String stringValue;
    private final double numericValue;

    //enum değerleri yapısı setGradeTaken metodu ve GradeTest sınıfı için oluşturuldu
    private Grade(String stringValue, double numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }
    //enum değerleri getter ve setterlar oluşturuldu
    public double getNumericValue() {
        return numericValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    //GradeTest'te kullanılacak toString() metodu yazıldı
    @Override
    public String toString() {
        return "Grade " + stringValue + " corresponds to numeric grade " + Math.round(numericValue);
    }

}
