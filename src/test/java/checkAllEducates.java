import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class checkAllEducates {

    @Test
    public void getAllPointOfStudentsForSamePeriod() {
        Student student1 = new Student(0.6);
        Student student2 = new Student(0.9);
        LocalDate from = LocalDate.of(2019, 11, 4);
        LocalDate to = LocalDate.of(2019, 11, 10);
        Internship internShip = new Internship(from, to);
        University university = new University(from, to);
        SelfLearning selfLearning = new SelfLearning();
        MeetUp meetUp = new MeetUp();
        Plan plan = new Plan(from, to);
        plan.addActivity(internShip);
        plan.addActivity(university);
        plan.addActivity(selfLearning);
        plan.addActivity(meetUp);
        plan.perform(student1);
        plan.perform(student2);

        Assertions.assertEquals(student1.getKnowledgePoints(), 99);
        Assertions.assertEquals(student1.getPracticePoints(), 128.4, 0.001);

        Assertions.assertEquals(student2.getKnowledgePoints(), 148.5);
        Assertions.assertEquals(student2.getPracticePoints(), 192.6);
    }
}