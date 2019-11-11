import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(0.5);
        List<Activity> activitiesForStudent1 = new ArrayList<>();
        activitiesForStudent1.add(new University(LocalDate.of(2019,11,7), LocalDate.of(2019,11,10)));

        Plan plan1 = new Plan(activitiesForStudent1, LocalDate.of(2019,11,7), LocalDate.of(2019,11,10));
        plan1.perform(student1);
        System.out.println(student1);
//        Period period = Period.between(LocalDate.of(2017,9,1),LocalDate.of(2019,5,30));
//        LocalDate.of(period.getYears(),)
//        System.out.println(period.ofDays());

    }
}
