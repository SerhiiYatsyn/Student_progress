import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class MeetUp implements KnowledgeSource, Activity {
    private final double knowledgePointsForOneLesson = 60;
    private final double practicePointsForOneLesson = 20;
    private DayOfWeek lessonDay = DayOfWeek.THURSDAY;

    public MeetUp() {
    }

    @Override
    public void educate(Student student) {
        student.addPoints(knowledgePointsForOneLesson * student.getEducationCoefficient(),
                practicePointsForOneLesson * student.getEducationCoefficient());
    }

    @Override
    public void tryToApply(Student student, LocalDate currentDate) {
        if (currentDate.getDayOfMonth() < 23) return;
        LocalDate lastThursdayOfMonth = currentDate;
        Month thisMonth = currentDate.getMonth();
        int step = 1;
        while (lastThursdayOfMonth.getDayOfWeek() != lessonDay && lastThursdayOfMonth.getMonth() != thisMonth.plus(1)) {
            if (lastThursdayOfMonth.getDayOfWeek() == lessonDay)
                step = 6;
            lastThursdayOfMonth = lastThursdayOfMonth.plusDays(step);
        }
        if (lastThursdayOfMonth.getMonth() == thisMonth.plus(1)) {
            lastThursdayOfMonth = lastThursdayOfMonth.minusDays(6);
        }
        if (currentDate.equals(lastThursdayOfMonth))
            educate(student);

    }
}
