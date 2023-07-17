package model;

import java.util.List;

public class LectureScheduleTime {

    private Day day;

    private List<Day[]> days;

    private String time;

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Day[]> getDays() {
        return days;
    }

    public void setDays(List<Day[]> days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "LectureScheduleTime{" +
                "day=" + day +
                ", time='" + time + '\'' +
                '}';
    }

    
}
