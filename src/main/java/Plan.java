import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plan {
    private List<Activity> activities;
    private LocalDate from;
    private LocalDate to;

    Plan(LocalDate from, LocalDate to) {
        this.activities = new ArrayList<>();
        this.from = from;
        this.to = to;
    }

    Plan(List<Activity> activities, LocalDate from, LocalDate to) {
        this.activities = activities;
        this.from = from;
        this.to = to;
    }
    public List<Activity> getActivities(){
        return new ArrayList<>(activities);
    }

    public void addActivity(Activity activity){
        this.activities.add(activity);
    }
//    Plan(Student student, List<Activity> activities) {
//        this.student = student;
//        this.activities = activities;
//    }

    public void perform(Student student) {
        LocalDate currentDate = this.from;
        while(!currentDate.equals(to)){
            for (Activity activity: activities) {
                activity.tryToApply(student, currentDate);
            }
            currentDate = currentDate.plusDays(1);
        }

    }
}
