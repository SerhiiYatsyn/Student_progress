public class Student {
    private double knowledgePoints;
    private double practicePoints;
    private double educationCoefficient;

    Student(double educationCoefficient) {
        this.knowledgePoints = 0;
        this.practicePoints = 0;
        this.educationCoefficient = educationCoefficient;
    }

    Student(double knowledgePoints, double practicePoints, double educationCoefficient) {
        this.knowledgePoints = knowledgePoints;
        this.practicePoints = practicePoints;
        this.educationCoefficient = educationCoefficient;
    }

    @Override
    public String toString() {
        return "Student{" +
                "knowledgePoints=" + knowledgePoints +
                ", practicePoints=" + practicePoints +
                ", educationCoefficient=" + educationCoefficient +
                '}';
    }

    public double getKnowledgePoints() {
        return knowledgePoints;
    }

    public double getPracticePoints() {
        return practicePoints;
    }

    public double getEducationCoefficient() {
        return educationCoefficient;
    }

    public void changeEducationCoefficient(double diff) {
        this.educationCoefficient += diff;
    }

    public void addPoints(double knowledgePoints, double practicePoints) {
        this.knowledgePoints += knowledgePoints;
        this.practicePoints += practicePoints;
    }


}
