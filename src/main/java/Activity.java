import java.time.LocalDate;

public interface Activity {
    void tryToApply(Student student, LocalDate currentDate);
}
