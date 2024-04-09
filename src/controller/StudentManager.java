package controller;
import model.Student;
import storage.IReadWriteFile;
import storage.ReadWriteFile;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private static IReadWriteFile readWriteFileStudent = new ReadWriteFile();
    private static List<Student> studentsList = readWriteFileStudent.readFile();
    public static void showStudentList() {
        if (studentsList.isEmpty()) {
            System.out.println("Not Student Found!");
        }
        for (Student student : studentsList) {
            System.out.println(student);
        }
    }

    public static void addNewStudent(Scanner scanner) {
        int id;
        boolean idExists;
        do{
            System.out.println("Enter ID: ");
            id = scanner.nextInt();
            idExists = false;
            for(Student student: studentsList){
                if(student.getId() == id){
                    System.err.println("ID already exists! Please entry again!");
                    idExists = true;
                    break;
                }
            }
        }while (idExists);
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Choice Gender: ");
        System.out.println("1. Male \n2. Female");
        int choice = scanner.nextInt();
        String gender = null;
        switch (choice){
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
            default:
                System.out.println("Invalid selection");
        }
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter avgScore");
        double avgScore = scanner.nextDouble();
        Student student = new Student(id,name,age,gender,address,avgScore);
        studentsList.add(student);
        readWriteFileStudent.writeFile(studentsList);
    }
    public static void removeStudent(int id) {
        Student removeStudents = null;
        for (Student student : studentsList) {
            if (student.getId() == id) {
                removeStudents = student;
                break;
            }
        }
        if (removeStudents != null) {
            studentsList.remove(removeStudents);
            readWriteFileStudent.writeFile(studentsList);
        } else {
            System.out.println("Not Student Found!");
        }
    }
    public static void updateStudent(int id, Scanner scanner) {
        boolean found = false;
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getId() == id) {
                found = true;
                System.out.println("Enter new information for student with ID " + id);
                scanner.nextLine();
                System.out.println("Enter Name: ");
                String name = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Enter age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Choice Gender: ");
                System.out.println("1. Male \n2. Female");
                int choice = scanner.nextInt();
                String gender = null;
                switch (choice){
                    case 1:
                        gender = "Male";
                        break;
                    case 2:
                        gender = "Female";
                        break;
                    default:
                        System.out.println("Invalid selection");
                }
                System.out.println("Enter Address: ");
                String address = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Enter avgScore");
                double avgScore = scanner.nextDouble();
                studentsList.get(i).setName(name);
                studentsList.get(i).setAge(age);
                studentsList.get(i).setAddress(address);
                studentsList.get(i).setGender(gender);
                studentsList.get(i).setAvgScore(avgScore);
                readWriteFileStudent.writeFile(studentsList);
                System.out.println("Student information updated successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found!");
        }
    }
    public static void sortAvgScoreAscending() {
        studentsList.sort(Comparator.comparingDouble(Student::getAvgScore));
        showStudentList();
    }
    public static void sortAvgScoreDescending() {
        studentsList.sort(Comparator.comparingDouble(Student::getAvgScore).reversed());
        showStudentList();
    }
}
