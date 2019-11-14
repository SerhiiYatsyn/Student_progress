import org.junit.Test;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

public class MeetUpTest {

    @Test
    public void checkCoefficient() {
        Student student1 = new Student(0.6);
        MeetUp meetUp = new MeetUp();
        List<Activity> activities = List.of(meetUp);
        Plan plan = new Plan(activities, LocalDate.of(2019, 11, 1), LocalDate.of(2019, 11, 30));
        plan.perform(student1);
        Assertions.assertEquals(student1.getKnowledgePoints(), 36);
        Assertions.assertEquals(student1.getPracticePoints(), 12);
    }

    @Test
    public void Internship__OneWeekday() {
        Student student1 = new Student(0.5);
        Student student2 = new Student(0.9);
        Internship internShip = new Internship(LocalDate.of(2019, 11, 7), LocalDate.of(2019, 11, 10));
        internShip.educate(student1);

        Assertions.assertEquals(student1.getKnowledgePoints(), 0); // coefficient must be greater than 0.5
        Assertions.assertEquals(student1.getPracticePoints(), 0);

        internShip.tryToApply(student2, LocalDate.of(2019, 11, 7));

        Assertions.assertEquals(student2.getKnowledgePoints(), 18);
        Assertions.assertEquals(student2.getPracticePoints(), 36);
    }

    @Test
    public void Internship__workWeek() {
        Student student1 = new Student(0.6);
        Internship internship = new Internship(LocalDate.of(2019, 11, 4), LocalDate.of(2019, 11, 9));
        List<Activity> activities = List.of(internship);
        Plan plan = new Plan(activities, LocalDate.of(2019, 11, 4), LocalDate.of(2019, 11, 9));
        plan.perform(student1);
        Assertions.assertEquals(student1.getKnowledgePoints(), 60);
        Assertions.assertEquals(student1.getPracticePoints(), 120);
    }

}