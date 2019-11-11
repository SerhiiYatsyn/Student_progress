import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class MeetUp implements KnowledgeSource, Activity {
    private final double knowledgePointsForOneLesson = 60;
    private final double practicePointsForOneLesson = 20;
    DayOfWeek lessonDay = DayOfWeek.THURSDAY;

    public MeetUp() {
    }

    @Override
    public void educate(Student student) {

    }

    @Override
    public void tryToApply(Student student, LocalDate currentDate) {
        LocalDate lastThursdayOfMonth = currentDate;
        Month thisMonth = currentDate.getMonth();
        int step = 1;
        while (lastThursdayOfMonth.getMonth() == thisMonth) {
            if (lastThursdayOfMonth.getDayOfWeek() == lessonDay) {
                step = 6;
            }
            lastThursdayOfMonth = lastThursdayOfMonth.plusDays(step);
        }

    }
}
