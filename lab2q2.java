import java.util.HashMap;
import java.util.Scanner;

public class Marks {
    // HashMap to store student marks
    private static HashMap<Integer, int[]> studentMarks = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add student marks: add [studentID]");
            System.out.println("2. Update student mark: update [studentID] [subjectID] [mark]");
            System.out.println("3. Get the average for a subject: average_s [studentID]");
            System.out.println("4. Get the average for a student: average [studentID]");
            System.out.println("5. Get the total mark of a student: total [studentID]");
            System.out.println("6. Exit");
            System.out.print("Enter your command: ");

            String command = scanner.nextLine();
            String[] parts = command.split("\\s+");

            switch (parts[0]) {
                case "add":
                    if (parts.length != 2) {
                        System.out.println("Invalid command format. Usage: add [studentID]");
                        break;
                    }
                    int studentID_add = Integer.parseInt(parts[1]);
                    if (!studentMarks.containsKey(studentID_add)) {
                        studentMarks.put(studentID_add, new int[]{0, 0, 0});
                        System.out.println("Student " + studentID_add + " added successfully.");
                    } else {
                        System.out.println("Student " + studentID_add + " already exists.");
                    }
                    break;

                case "update":
                    if (parts.length != 4) {
                        System.out.println("Invalid command format. Usage: update [studentID] [subjectID] [mark]");
                        break;
                    }
                    int studentID_update = Integer.parseInt(parts[1]);
                    int subjectID_update = Integer.parseInt(parts[2]) - 1; // converting to zero-based index
                    int mark_update = Integer.parseInt(parts[3]);
                    if (studentMarks.containsKey(studentID_update)) {
                        int[] marks = studentMarks.get(studentID_update);
                        if (subjectID_update >= 0 && subjectID_update < marks.length) {
                            marks[subjectID_update] = mark_update;
                            studentMarks.put(studentID_update, marks);
                            System.out.println("Student " + studentID_update + "'s marks for subject " + (subjectID_update + 1) + " was updated to " + mark_update + ".");
                        } else {
                            System.out.println("Invalid subject ID.");
                        }
                    } else {
                        System.out.println("Student " + studentID_update + " does not exist.");
                    }
                    break;

                case "average_s":
                    if (parts.length != 2) {
                        System.out.println("Invalid command format. Usage: average_s [studentID]");
                        break;
                    }
                    int studentID_average_s = Integer.parseInt(parts[1]);
                    if (studentMarks.containsKey(studentID_average_s)) {
                        int[] marks = studentMarks.get(studentID_average_s);
                        double average = calculateAverage(marks);
                        System.out.println("Student " + studentID_average_s + " has an average of " + average + " across all subjects.");
                    } else {
                        System.out.println("Student " + studentID_average_s + " does not exist.");
                    }
                    break;

                case "average":
                    if (parts.length != 2) {
                        System.out.println("Invalid command format. Usage: average [studentID]");
                        break;
                    }
                    int studentID_average = Integer.parseInt(parts[1]);
                    if (studentMarks.containsKey(studentID_average)) {
                        int[] marks = studentMarks.get(studentID_average);
                        double average = calculateAverage(marks);
                        System.out.println("Average marks for Student " + studentID_average + ": " + average);
                    } else {
                        System.out.println("Student " + studentID_average + " does not exist.");
                    }
                    break;

                case "total":
                    if (parts.length != 2) {
                        System.out.println("Invalid command format. Usage: total [studentID]");
                        break;
                    }
                    int studentID_total = Integer.parseInt(parts[1]);
                    if (studentMarks.containsKey(studentID_total)) {
                        int[] marks = studentMarks.get(studentID_total);
                        int totalMarks = marks[0] + marks[1] + marks[2];
                        System.out.println("Total marks for Student " + studentID_total + ": " + totalMarks);
                    } else {
                        System.out.println("Student " + studentID_total + " does not exist.");
                    }
                    break;

                case "exit":
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid command. Please enter a valid command.");
                    break;
            }
        }

        scanner.close();
    }

    // Helper method to calculate average
    private static double calculateAverage(int[] marks) {
        int sum = marks[0] + marks[1] + marks[2];
        return (double) sum / 3;
    }
}

