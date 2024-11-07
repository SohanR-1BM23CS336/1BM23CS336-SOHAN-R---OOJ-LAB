import java.util.Scanner;
class quadratic {
    float d;
    Scanner sc = new Scanner(System.in);

    void check()

    {
        System.out.println("enter the values of a,b, and c");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();


        if (a == 0) {
            System.out.println("invalid equation");
        }
        else{
            d= b*b - 4*a*c;
            System.out.println(d);
            System.out.println("the solutions are");
            if(d>0){
                System.out.println("roots are unique ");
                double r1 = (-b+Math.sqrt(d))/(2*a);
                double r2 = (-b-Math.sqrt(d))/(2*a);
                System.out.println(r1 +" " + r2);
            }
            if(d==0){
                System.out.println("roots are equal ");
                double r = -b/(2*a);
                System.out.println(r);
            }
            if(d<0){
                System.out.println("roots are imaginary");
                double r1 = Math.sqrt(-d)/(2*a);
                double r2= (-b)/(2*a);
                System.out.println(r2+"+i"+r1 + " "+r2+"-i"+r1 );
            }

        }

    }


}

public class Quadratic {
    public static void main(String[] args) {
        quadratic q1 = new quadratic();
         q1.check();

    }
}
