import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class SelfLearning implements KnowledgeSource, Activity {
    private final int knowledgePointsForOneDay = 5;
    private final int practicePointsForOneDay = 3;
    private List<DayOfWeek> allowedDaysOfWeek = Arrays.asList(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

    @Override
    public void educate(Student student) {
        student.addPoints(knowledgePointsForOneDay * student.getEducationCoefficient(),
                practicePointsForOneDay * student.getEducationCoefficient());
    }

    @Override
    public void tryToApply(Student student, LocalDate currentDate) {
        if (allowedDaysOfWeek.contains(currentDate.getDayOfWeek())) {
            this.educate(student);
        }
    }
}
