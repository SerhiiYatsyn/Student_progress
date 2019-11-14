import org.junit.Test;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelfLearningTest {

    @Test
    public void checkCoefficient() {
        Student student1 = new Student(0.5);
        Student student2 = new Student(0.9);
        SelfLearning selfLearning = new SelfLearning();
        selfLearning.educate(student1);
        selfLearning.educate(student2);

        Assertions.assertEquals(student1.getKnowledgePoints(), 2.5);
        Assertions.assertEquals(student1.getPracticePoints(), 1.5);

        Assertions.assertEquals(student2.getKnowledgePoints(), 4.5);
        Assertions.assertEquals(student2.getPracticePoints(), 2.7);
    }

    @Test
    public void SelfLearning__workWeek() {
        Student student1 = new Student(0.6);
        SelfLearning selfLearning = new SelfLearning();
        List<Activity> activities = List.of(selfLearning);
        Plan plan = new Plan(activities, LocalDate.of(2019, 11, 4), LocalDate.of(2019, 11, 10));
        plan.perform(student1);
        Assertions.assertEquals(student1.getKnowledgePoints(), 9);
        Assertions.assertEquals(student1.getPracticePoints(), 5.4,0.001);
    }

}