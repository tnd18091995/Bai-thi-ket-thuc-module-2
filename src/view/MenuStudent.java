package view;

import controller.StudentManager;
import java.util.Scanner;

public class MenuStudent {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("-----StudentManager-----");
                System.out.println("1. Show ListStudents");
                System.out.println("2. Add Student");
                System.out.println("3. Update Student");
                System.out.println("4. Remove Student");
                System.out.println("5. Sort Student");
                System.out.println("0. Exit ");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        StudentManager.showStudentList();
                        break;
                    case 2:
                        StudentManager.addNewStudent(scanner);
                        break;
                    case 3:
                        System.out.println("Enter ID Student");
                        int idUpdate = scanner.nextInt();
                        StudentManager.updateStudent(idUpdate,scanner);
                        break;
                    case 4:
                        System.out.println("Enter ID Student");
                        int idRemove = scanner.nextInt();
                        StudentManager.removeStudent(idRemove);
                        break;
                    case 5:
                        MenuSortStudent.sortStudent();
                    case 0:
                        System.out.println("Exit Program");
                        break;
                    default:
                        System.out.println("Try Enter Again!");
                        break;
                }
            } while (choice != 0);
        }
    }
