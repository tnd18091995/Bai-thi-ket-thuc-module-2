package view;

import controller.StudentManager;

import java.util.Scanner;
public class MenuSortStudent{
public static void sortStudent() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-----Sort Student-----");
            System.out.println("1. Ascending");
            System.out.println("2. Descending");
            System.out.println("0. Exit ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    StudentManager.sortAvgScoreAscending();
                    break;
                case 2:
                    StudentManager.sortAvgScoreDescending();
                    break;
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
