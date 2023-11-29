package Java_student_management;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem2 {
    private static ArrayList<Student> students = new ArrayList<>();
    private static int studentIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Get Student Marks");
            System.out.println("4. Show Students Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    removeStudent(scanner);
                    break;
                case 3:
                    getStudentMarks(scanner);
                    break;
                case 4:
                    showStudentsDetails();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.println("\nAdding a new student:");

        System.out.print("Enter student name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter class(1 MSc DS, 2 MSc DS, 3 MSc DS,4 MSc DS): ");
        String studentClass = scanner.nextLine();

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        System.out.println("Enter 5 Subject marks.");

        System.out.print("NNDL: ");
        double nnldMarks = scanner.nextDouble();

        System.out.print("TS: ");
        double tsMarks = scanner.nextDouble();

        System.out.print("NLP: ");
        double nlpMarks = scanner.nextDouble();

        System.out.print("BI: ");
        double biMarks = scanner.nextDouble();

        System.out.print("CLOUD: ");
        double cloudMarks = scanner.nextDouble();

        Student student = new Student(studentIdCounter++, name, rollNumber, studentClass, department, nnldMarks,
                tsMarks, nlpMarks, biMarks, cloudMarks);

        students.add(student);
        System.out.println("Student added successfully.");
    }

    private static void removeStudent(Scanner scanner) {
        System.out.println("\nRemoving a student:");

        System.out.print("Enter the roll number of the student to be removed: ");
        scanner.nextLine();

        int rollNumber = Integer.parseInt(scanner.nextLine());

        // Searching for the student by roll number
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                System.out.println("Student removed successfully.");
                return;
            }
        }

        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    private static void getStudentMarks(Scanner scanner) {
        System.out.println("\nGetting student marks:");

        System.out.print("Enter the roll number of the student: ");
        scanner.nextLine();
        int rollNumber = Integer.parseInt(scanner.nextLine());

        // Searching for the student by roll number
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Marks for student with roll number " + rollNumber + ":");
                System.out.println("NNDL: " + student.getNndlMarks());
                System.out.println("TS: " + student.getTsMarks());
                System.out.println("NLP: " + student.getNlpMarks());
                System.out.println("BI: " + student.getBiMarks());
                System.out.println("CLOUD: " + student.getCloudMarks());
                return;
            }
        }

        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    private static void showStudentsDetails() {
        System.out.println("\nShowing students details:");

        System.out.print("ID  Name          Roll Number Class    Department          \n");
        for (Student student : students) {

            System.out.printf("%-4d%-14s%-12d%-9s%-20s\n",
                    student.getStudentId(),
                    student.getName(),
                    student.getRollNumber(),
                    student.getStudentClass(),
                    student.getDepartment());
        }

        System.out.println("MARKS OF STUDENTS:");

        System.out.println("\nMark sheet:\n");

        System.out.print("NAME          ROLLNO.   NNDL  TS    NLP   BI    CLOUD TOTAL  PERCENTAGE\n");

        for (Student student : students) {

            Double TOTAL = student.getNndlMarks() + student.getTsMarks() + student.getNlpMarks() + student.getBiMarks()
                    + student.getCloudMarks();
            Double Perc = (TOTAL / 500) * 100;

            System.out.printf("%-14s%-10d%-6.2f%-6.2f%-6.2f%-6.2f%-6.2f%-7.0f%-6.2f\n",
                    student.getName(),
                    student.getRollNumber(),
                    student.getNndlMarks(),
                    student.getTsMarks(),
                    student.getNlpMarks(),
                    student.getBiMarks(),
                    student.getCloudMarks(),
                    TOTAL,
                    Perc);

        }
        System.out.println("\n------------------------------");
    }
}

class Student {
    private int studentId;
    private String name;
    private int rollNumber;
    private String studentClass;
    private String department;
    private double nnldMarks;
    private double tsMarks;
    private double nlpMarks;
    private double biMarks;
    private double cloudMarks;

    public Student(int studentId, String name, int rollNumber, String studentClass, String department,
            double nnldMarks, double tsMarks, double nlpMarks, double biMarks, double cloudMarks) {
        this.studentId = studentId;
        this.name = name;
        this.rollNumber = rollNumber;
        this.studentClass = studentClass;
        this.department = department;
        this.nnldMarks = nnldMarks;
        this.tsMarks = tsMarks;
        this.nlpMarks = nlpMarks;
        this.biMarks = biMarks;
        this.cloudMarks = cloudMarks;
    }

    // Getter methods

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public String getDepartment() {
        return department;
    }

    public double getNndlMarks() {
        return nnldMarks;
    }

    public double getTsMarks() {
        return tsMarks;
    }

    public double getNlpMarks() {
        return nlpMarks;
    }

    public double getBiMarks() {
        return biMarks;
    }

    public double getCloudMarks() {
        return cloudMarks;
    }
}
