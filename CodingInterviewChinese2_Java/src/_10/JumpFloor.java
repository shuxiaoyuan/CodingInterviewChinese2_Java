package _10;


/**
 * 面试题10：青蛙跳台阶问题
 * P77
 */

public class JumpFloor {

    public static void main(String[] args) {
        System.out.println(jumpFloor(6));
    }

    public static int jumpFloor(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int fibn = 0;
        int fibn_1 = 2;
        int fibn_2 = 1;
        for(int i = 3; i <= n; i++) {
            fibn = fibn_2 + fibn_1;
            fibn_2 = fibn_1;
            fibn_1 = fibn;
        }
        return fibn;
    }
    
}
