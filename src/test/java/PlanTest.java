import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanTest {

    @Test
    public void testCheckedDays__withUniversity__OneWeekday() {
        Student student1 = new Student(0.5);
        List<Activity> activitiesForStudent1 = new ArrayList<>();
        activitiesForStudent1.add(new University(LocalDate.of(2019, 11, 8), LocalDate.of(2019, 11, 10)));
        Plan plan1 = new Plan(activitiesForStudent1, LocalDate.of(2019, 11, 8), LocalDate.of(2019, 11, 10));
        plan1.perform(student1);
        Assertions.assertEquals(student1.getKnowledgePoints(),5);
        Assertions.assertEquals(student1.getPracticePoints(),0.5);
    }

    @Test
    public void test_ListOfActivities() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        Plan plan1 = new Plan(yesterday, tomorrow);
        assertEquals(plan1.getActivities().size(), 0); // must be 0

        plan1.addActivity(new Activity() {
            @Override
            public void tryToApply(Student student, LocalDate date) {
            }
        });

        assertEquals(plan1.getActivities().size(), 1); // must be 0
    }

}