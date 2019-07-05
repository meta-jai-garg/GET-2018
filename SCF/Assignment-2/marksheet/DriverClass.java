package marksheet;

public class DriverClass {
    public static void main(String[] args) {
        float[] grades = {60, 50, 80.03f, 33.33f, 60, 64};
        Grading grading = new Grading();
        System.out.println("Average Marks : " + grading.averageGrade(grades));
        System.out.println("Maximum Marks : " + grading.maximumGrade(grades));
        System.out.println("Minimum Marks : " + grading.minimumGrade(grades));
        System.out.println("Pass Percentage : " + grading.passedStudentPercentage(grades));
    }
}
