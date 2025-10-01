package com.examly.springapp;


import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringappApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("1. Add Hotel Details");
                break;
            case 2:
                System.out.println("2. Display All Hotels");
                break;
            case 3:
                System.out.println("3. Update Hotel by ID");
                break;
            case 4:
                System.out.println("4. Delete Hotel by ID");
                break;
            case 5:
                System.out.println("5. Exit");
                break;
            default:
                System.out.println("Invalid choice");
        }
        scanner.close();
    }
    // Rest of the methods for sorting and displaying data
}
