package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        StudentDatabase student1 = new StudentDatabase();
//        System.out.println("Student's id: " + student1.generateID());
//        System.out.println("Student's status: \n" + student1.getStatus());
//        student1.enroll();
//        System.out.println(student1.payTuition(300));
//        System.out.println(student1.payTuition(400));

        System.out.println("Enter how many students to be enrolled: ");
        Scanner scanner = new Scanner(System.in);
        int numOfStudents = scanner.nextInt();
        StudentDatabase[] students = new StudentDatabase[numOfStudents];

        for (int i = 0; i < students.length; i++) {
            students[i] = new StudentDatabase();
            students[i].enroll();
            System.out.println("Student's id: " + students[i].generateID());
            System.out.println("Student's status: \n" + students[i].getStatus());
        }


    }
}
