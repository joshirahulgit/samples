/**
 * Created by rahul on 2/7/17.
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    private static double fib(double n) {
        if (n == 0 || n == 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}
