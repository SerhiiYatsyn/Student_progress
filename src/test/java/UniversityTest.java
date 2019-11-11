import org.junit.Test;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityTest {
    @Test
    public void checkCoefficient() { // must be greater than 0.3 to execute
        Student student1 = new Student(0.3);
        Student student2 = new Student(0.4);
        University university = new University(LocalDate.of(2019, 11, 7), LocalDate.of(2019, 11, 10));
        university.educate(student1);
        university.educate(student2);

        Assertions.assertEquals(student1.getKnowledgePoints(), 0); // coefficient must be greater than 0.3
        Assertions.assertEquals(student1.getPracticePoints(), 0);

        Assertions.assertEquals(student2.getKnowledgePoints(), 4);
        Assertions.assertEquals(student2.getPracticePoints(), 0.4);
    }

    @Test
    public void test_University__OneWeekday() {
        Student student1 = new Student(0.5);
        Student student2 = new Student(0.9);
        University university = new University(LocalDate.of(2019, 11, 7), LocalDate.of(2019, 11, 10));
        university.educate(student1);

        Assertions.assertEquals(student1.getKnowledgePoints(), 5);
        Assertions.assertEquals(student1.getPracticePoints(), 0.5);

        university.tryToApply(student2,LocalDate.of(2019, 11, 7));

        Assertions.assertEquals(student2.getKnowledgePoints(), 9);
        Assertions.assertEquals(student2.getPracticePoints(), 0.9);
    }

    @Test
    public void test_University__workWeek() {
        Student student1 = new Student(0.5);
        University university = new University(LocalDate.of(2019, 11, 4), LocalDate.of(2019, 11, 9));
        List<Activity> activities = List.of(university);
        Plan plan = new Plan(activities, LocalDate.of(2019, 11, 4), LocalDate.of(2019, 11, 9));
        plan.perform(student1);
        Assertions.assertEquals(student1.getKnowledgePoints(), 25);
        Assertions.assertEquals(student1.getPracticePoints(), 2.5);
    }
}