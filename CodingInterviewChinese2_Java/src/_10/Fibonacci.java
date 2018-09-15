package _10;


/**
 * 面试题10：斐波那契数列
 * P74
 */

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    public static int fib(int n) {
        return by_recursive(n);
    }
    
    public static int by_recursive(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return by_recursive(n - 1) + by_recursive(n - 2);
    }
    
    public static int by_iterative(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int fibn = 0;
        int fibn_2 = 0;
        int fibn_1 = 1;
        for(int i = 2; i <= n; i++) {
            fibn = fibn_2 + fibn_1;
            fibn_2 = fibn_1;
            fibn_1 = fibn;
        }
        return fibn;
    }
    
}
