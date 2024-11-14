import CIE.*;
import SEE.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        External[] students = new External[n];
        Internals[] internals = new Internals[n];
        
        for (int i = 0; i < n; i++) {
            sc.nextLine(); // Consume the newline character
            System.out.println("\nEnter details for student " + (i + 1));
            
            System.out.print("Enter USN: ");
            String usn = sc.nextLine();
            
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter Semester: ");
            int sem = sc.nextInt();
            
            students[i] = new External(usn, name, sem);
            internals[i] = new Internals();
            
            System.out.println("Enter internal marks for 5 courses:");
            int[] internalMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                internalMarks[j] = sc.nextInt();
            }
            internals[i].setInternalMarks(internalMarks);
            
            System.out.println("Enter SEE marks for 5 courses:");
            int[] seeMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                seeMarks[j] = sc.nextInt();
            }
            students[i].setSeeMarks(seeMarks);
        }
        
        System.out.println("\nFinal Marks of Students:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + " (" + students[i].usn + ", " + students[i].name + "):");
            
            int[] internalMarks = internals[i].getInternalMarks();
            int[] seeMarks = students[i].getSeeMarks();
            
            for (int j = 0; j < 5; j++) {
                int finalMarks = internalMarks[j] + (seeMarks[j] / 2); // Assuming SEE marks are out of 100
                System.out.println("Course " + (j + 1) + " Final Marks: " + finalMarks);
            }
        }

        sc.close();
    }
}