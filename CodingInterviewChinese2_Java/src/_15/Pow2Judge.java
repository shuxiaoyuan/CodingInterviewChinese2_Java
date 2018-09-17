package _15;


/**
 * 面试题15：二进制中1的个数
 * P103
 */
public class Pow2Judge {

    public static void main(String[] args) {
        System.out.println(is2Pow(1));
    }

    public static boolean is2Pow(int num) {
        return true ? ((num & (num - 1)) == 0 && num != 0) : false;
    }
    
}
