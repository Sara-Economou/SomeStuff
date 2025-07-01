//This project is a simple recursion activity made using Java and a few Calculus formulas
//import your package name

import java.util.Scanner;

public class RecursionCalc {

    // Factorial method
    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Power method 
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / power(x, -n);
        }
        return x * power(x, n - 1);
    }

    // Taylor series for e^x 
    public static double Taylor(double x, int n) {
        if (n == 0) {
            return 1;
        }
        return power(x, n) / factorial(n) + Taylor(x, n - 1);
    }

    // nth derivative of sin(x) at x=0
    public static double nDerivativeAtZero(int n) {
        if (n % 2 == 0) {
            return 0;
        }
        if (n % 4 == 1) {
            return 1;
        } else {
            return -1;
        }
    }

    // MacLaurin series for sin(x)
    public static double MacLaurin(double x, int n) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            double val = nDerivativeAtZero(i) * Math.pow(x, i) / factorial(i);
            sum += val;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("Enter your x value: ");
        double x = scnr.nextDouble();
        
        System.out.print("Enter terms (n): ");
        int n = scnr.nextInt();  
        
        System.out.println("Taylor Series: e^" + x + " approximation: " + Taylor(x, n));
        System.out.println("MacLaurin Series: sin(" + x + ") approximation: " + MacLaurin(x, n));
        
        scnr.close();
    }
}
