package com.abc.springcore.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //no of entries to add to the map
        int n = Integer.parseInt(sc.nextLine());

        HashSet<Student> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int id = Integer.parseInt(sc.nextLine());
            String name = sc.nextLine();
            int marks = Integer.parseInt(sc.nextLine());
            //create student object with input values
            Student stu = new Student(id, name, marks);
            //add to the HashSet
            set.add(stu);
            System.out.println("Added Successfully.");
        }

        //1 - Search by student name

        //read student name as input for searching
        String inputName1 = sc.nextLine();

        //check name is existing inside set
        boolean searchFlag = false;
        for (Student stObj : set) {
            if (inputName1.equals(stObj.getStudentName())) {
                searchFlag = true;
                System.out.println(stObj);
                break;
            }
        }
        if (searchFlag == false) {
            System.out.println("Student not found with name: " + inputName1);
        }

        //2- update marks

        //read key - student name
        String inputName2 = sc.nextLine();

        //read new marks to update
        int newMarks = Integer.parseInt(sc.nextLine());

        boolean updateFlag = false;
        for (Student stObj : set) {
            if (inputName1.equals(stObj.getStudentName())) {
                updateFlag = true;
                stObj.setTotalMarks(newMarks); //calling setter method to update marks in student object
                System.out.println("Updated Successfully.");
                break;
            }
        }
        if (updateFlag == false) {
            System.out.println("Student not found with name: " + inputName2);
        }

        //3 - Delete

        String inputName3 = sc.nextLine();

        boolean deleteFlag = false;
        for (Student stObj : set) {
            if (inputName1.equals(stObj.getStudentName())) {
                deleteFlag = true;
                set.remove(stObj); //this remove object from set
                System.out.println("Deleted Successfully.");
                break;
            }
        }
        if (deleteFlag == false) {
            System.out.println("Student not found with name: " + inputName2);
        }

        //4 - Display all
        for (Student stObj : set) {
            System.out.println(stObj);
        }
    }
}


