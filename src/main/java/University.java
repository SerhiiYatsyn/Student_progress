import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

public class University implements KnowledgeSource, Activity {
    private final double knowledgePointsForOneDay = 10;
    private final double practicePointsForOneDay = 1;
    private LocalDate from;
    private LocalDate to;
    private List<DayOfWeek> notAllowedDaysOfWeek = Arrays.asList(DayOfWeek.SUNDAY, DayOfWeek.SATURDAY);
    private List<Month> notAllowedMonths = Arrays.asList(Month.JUNE, Month.JULY, Month.AUGUST);

    University(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    private boolean isStudentCredited(Student student) {
        return student.getEducationCoefficient() > 0.3;
    }

    @Override
    public void educate(Student student) {
        if (isStudentCredited(student))
            student.addPoints(knowledgePointsForOneDay * student.getEducationCoefficient(),
                    practicePointsForOneDay * student.getEducationCoefficient());
    }

    @Override
    public void tryToApply(Student student, LocalDate currentDate) {
        if ((currentDate.isAfter(from) && currentDate.isBefore(to)) || currentDate.equals(from) || currentDate.equals(to)) {
            if (!notAllowedDaysOfWeek.contains(currentDate.getDayOfWeek())) {
                if (!notAllowedMonths.contains(currentDate.getMonth())) {
                    this.educate(student);
                }
            }
        }
    }
}
