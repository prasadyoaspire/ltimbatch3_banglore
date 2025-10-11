package com.abc.springcore.practice;

import java.util.ArrayList;
import java.util.Iterator;

public class ListDemo {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "Alice", 20));
        students.add(new Student(2, "Bob", 22));
        students.add(new Student(3, "Charlie", 19));

        int id = 3; // input student to delete.

        Iterator<Student> itr = students.iterator();

        while(itr.hasNext()) {
            Student st = itr.next();
            if (st.getStudentId() == id) {
                itr.remove();
                System.out.println("removed successfully");
                //break;
            }
        }
        students.forEach(s->System.out.println(s));
    }
}
