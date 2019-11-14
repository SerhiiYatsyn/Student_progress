import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Internship implements KnowledgeSource, Activity {
    private final double knowledgePointsForOneDay = 20;
    private final double practicePointsForOneDay = 40;
    private List<DayOfWeek> notAllowedDaysOfWeek = Arrays.asList(DayOfWeek.SUNDAY, DayOfWeek.SATURDAY);

    private LocalDate from;
    private LocalDate to;

    Internship(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void tryToApply(Student student, LocalDate currentDate) {
        if ((currentDate.isAfter(from) && currentDate.isBefore(to)) || currentDate.equals(from) || currentDate.equals(to)) {
            if (!notAllowedDaysOfWeek.contains(currentDate.getDayOfWeek())) {
                this.educate(student);
            }
        }
    }

    private boolean isStudentCredited(Student student) {
        return student.getEducationCoefficient() > 0.5;
    }

    @Override
    public void educate(Student student) {
        if (isStudentCredited(student))
            student.addPoints(knowledgePointsForOneDay * student.getEducationCoefficient(),
                    practicePointsForOneDay * student.getEducationCoefficient());
    }
}
