import java.util.Scanner;
public class cgpa {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

              
                System.out.print("Enter the number of subjects: ");
                int numSubjects = scanner.nextInt();

                double[] gradePoints = new double[numSubjects];
                int[] credits = new int[numSubjects];
                int totalCredits = 0;
                double total = 0;

               
                for (int i = 0; i < numSubjects; i++) {
                    System.out.print("Enter the grade points for subject " + (i + 1) + ": ");
                    gradePoints[i] = scanner.nextDouble();

                    System.out.print("Enter the credits for subject " + (i + 1) + ": ");
                    credits[i] = scanner.nextInt();
 
                    total += gradePoints[i] * credits[i];
                    totalCredits += credits[i];
                }

                double cgpa =  total / totalCredits;
                System.out.printf("Your CGPA is:" + cgpa);

               
            }
        }
