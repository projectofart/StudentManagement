import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    public String firstName;
    public String lastName;
    public int age;

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Age: " + age;
    }
}

public class Main {
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    enterStudentList(scanner);
                    break;
                case 2:
                    findStudentsByLastName(scanner);
                    break;
                case 3:
                    findAndEditStudentsByFullName(scanner);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }

    static void enterStudentList(Scanner scanner) {
        System.out.println("Enter student list (press Enter to finish):");
        String input;
        do {
            Student student = new Student();
            System.out.print("Enter student's first name: ");
            student.firstName = scanner.nextLine();
            System.out.print("Enter student's last name: ");
            student.lastName = scanner.nextLine();
            System.out.print("Enter student's age: ");
            student.age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            studentList.add(student);
            System.out.print("Press Enter to add another student or type 'exit' to finish: ");
            input = scanner.nextLine();
        } while (!input.equals("exit"));
    }

    static void findStudentsByLastName(Scanner scanner) {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.lastName.equalsIgnoreCase(lastName)) {
                foundStudents.add(student);
            }
        }
        if (!foundStudents.isEmpty()) {
            System.out.println("Found students with last name '" + lastName + "':");
            for (Student student : foundStudents) {
                System.out.println(student);
            }
        } else {
            System.out.println("No students found with last name '" + lastName + "'.");
        }
    }

    static void findAndEditStudentsByFullName(Scanner scanner) {
        System.out.print("Enter full name to search: ");
        String fullName = scanner.nextLine();
        boolean found = false;
        for (Student student : studentList) {
            if ((student.firstName + " " + student.lastName).equalsIgnoreCase(fullName)) {
                System.out.println("Found student: " + student);
                System.out.println("Enter new information:");
                System.out.print("Enter new first name: ");
                student.firstName = scanner.nextLine();
                System.out.print("Enter new last name: ");
                student.lastName = scanner.nextLine();
                System.out.print("Enter new age: ");
                student.age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Student information updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No student found with full name '" + fullName + "'.");
        }
    }
}
