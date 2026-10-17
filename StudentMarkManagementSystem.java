import java.util.Scanner;

public class StudentMarkManagement {

    static String getGrade(double average, boolean passed) {
        if (!passed) return "F";
        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else return "D";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] subjects = {"Tamil", "English", "Maths", "Science", "Social"};
        final int PASS_MARK = 35;

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        int[] totals = new int[n];
        double[] averages = new double[n];
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.print("  Name: ");
            names[i] = sc.next();
            int total = 0;
            boolean passed = true;
            for (String sub : subjects) {
                System.out.print("  " + sub + " mark: ");
                int mark = sc.nextInt();
                total += mark;
                if (mark < PASS_MARK) passed = false;
            }
            totals[i] = total;
            averages[i] = (double) total / subjects.length;
            grades[i] = getGrade(averages[i], passed);
        }

        String line = "=".repeat(52);
        System.out.println("\n" + line);
        System.out.printf("%-5s%-14s%8s%10s%8s%n", "No", "Name", "Total", "Average", "Grade");
        System.out.println(line);
        for (int i = 0; i < n; i++) {
            System.out.printf("%-5d%-14s%8d%10.2f%8s%n", i + 1, names[i], totals[i], averages[i], grades[i]);
        }
        System.out.println(line);
    }
}