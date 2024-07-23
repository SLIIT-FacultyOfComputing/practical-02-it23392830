import java.util.Scanner;

public class StudentMarksApp {

    public static void main(String[] args) {
        Marks marksManager = new Marks(); // Create an instance of Marks class
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu(); // Display the menu options
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
                    marksManager.addStudent(studentID_add);
                    break;

                case "update":
                    if (parts.length != 4) {
                        System.out.println("Invalid command format. Usage: update [studentID] [subjectID] [mark]");
                        break;
                    }
                    int studentID_update = Integer.parseInt(parts[1]);
                    int subjectID_update = Integer.parseInt(parts[2]);
                    int mark_update = Integer.parseInt(parts[3]);
                    marksManager.updateStudentMark(studentID_update, subjectID_update, mark_update);
                    break;

                case "average_s":
                    if (parts.length != 2) {
                        System.out.println("Invalid command format. Usage: average_s [studentID]");
                        break;
                    }
                    int studentID_average_s = Integer.parseInt(parts[1]);
                    marksManager.displayAverageSubject(studentID_average_s);
                    break;

                case "average":
                    if (parts.length != 2) {
                        System.out.println("Invalid command format. Usage: average [studentID]");
                        break;
                    }
                    int studentID_average = Integer.parseInt(parts[1]);
                    marksManager.displayAverageStudent(studentID_average);
                    break;

                case "total":
                    if (parts.length != 2) {
                        System.out.println("Invalid command format. Usage: total [studentID]");
                        break;
                    }
                    int studentID_total = Integer.parseInt(parts[1]);
                    marksManager.displayTotalMarks(studentID_total);
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

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add student marks: add [studentID]");
        System.out.println("2. Update student mark: update [studentID] [subjectID] [mark]");
        System.out.println("3. Get the average for a subject: average_s [studentID]");
        System.out.println("4. Get the average for a student: average [studentID]");
        System.out.println("5. Get the total mark of a student: total [studentID]");
        System.out.println("6. Exit");
    }
}

