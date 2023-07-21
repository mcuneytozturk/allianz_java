package util;

public enum Grade {
    A("A", 4), B("B", 3), C("C", 2), D("D", 1), F("F", 0);

    private final String stringValue;
    private final double numericValue;

    private Grade(String stringValue, double numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }

    public double getNumericValue() {
        return numericValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    @Override
    public String toString() {
        return "Grade " + stringValue + " corresponds to numeric grade " + Math.round(numericValue);
    }

}
