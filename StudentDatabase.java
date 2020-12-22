package com.company;

import java.util.Scanner;

public class StudentDatabase {
    private String name;
    private int gradeYear;
    private String course;
    private String id;
    private double costOfCourse = 600;
    private double balance = 0;

    //Ask the user how many new students will be added to the database

    // The user should be prompted to enter the name and year for each student
    public StudentDatabase() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter students name: ");
        this.name = scanner.nextLine();

        System.out.println("Enter students year level (1=Freshman, 2= Sophomore, 3=Junior, 4=Senior)");
        this.gradeYear = scanner.nextInt();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeYear() {
        return gradeYear;
    }

    public void setGradeYear(int gradeYear) {
        this.gradeYear = gradeYear;
    }

    public String getCourses() {
        return course;
    }

    // A student can enroll in the following courses:
    //History 101 Mathematics 101 English 101 Chemistry 101 Computer Science 101
    // Each course costs $600 to enroll
    public void enroll() {
        String totalCourses = "";

        while (1 != 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter course name (History, Mathematics, English, Chemistry, Computer Science): ");
            System.out.println("Type Q to quit ");
            String courses = scanner.nextLine();
            if (!courses.equals("Q")) {
                if (courses.equals("History") || courses.equals("Mathematics") || courses.equals("English")
                        || courses.equals("Chemistry") || courses.equals("Computer Science")) {
                    if (totalCourses.equals("")) {
                        totalCourses = courses;
                    } else {
                        totalCourses = totalCourses + ", " + courses;
                    }
                    balance = balance + costOfCourse;
                }
            } else {
                break;
            }
        }

        course = totalCourses;
        System.out.println("Enrolled in: " + totalCourses);
        System.out.println("Tuition balance: $" + balance);
    }

    // To see the status of the student, we should see their name, ID, courses enrolled, and balance
    public String getStatus() {
        return "Name: " + getName() + "\nID: " + getId() + "\nCourse enrolled: " + getCourses() + "\nBalance: $" + getBalance();
    }

    // The student should be able to view their balance and pay the tuition
    public double payTuition(double payment){
        balance = balance - payment;
        if (balance < 0) {
            balance = 0;
        }
        return balance;
    }

    public String getId() {
        return id;
    }

    // The student should have a 5-digit unique ID, with the first number being their grade level
    public String generateID() {
        int idLength = 5;
        String setNumbers = "0123456789";
        StringBuilder sb = new StringBuilder();
        sb.append(this.gradeYear);

        for (int i = 1; i < idLength; i++) {
            int random = (int) (Math.random() * setNumbers.length());
            sb.append(random);
        }
        id = sb.toString();
        return id;
    }

    public void setId(String id) {
        if (id.length() == 5) {
            this.id = id;
        } else {
            this.id = "Invalid. ID must be 5 digits";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
