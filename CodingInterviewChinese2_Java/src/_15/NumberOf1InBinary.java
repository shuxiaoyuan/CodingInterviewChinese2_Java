package _15;


/**
 * 面试题15：二进制中1的个数
 * P100
 *
 */
public class NumberOf1InBinary {

    public static void main(String[] args) {
        System.out.println(numsOf1(-1));
    }

    public static int numsOf1(int n) {
        //return byShift(n);
        return byN_1(n);
    }
    
    public static int byShift(int n) {
        int count = 0;
        int flag = 1;
        for(int i = 0; i < 32; i++) {
            if((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
    
    public static int byN_1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
    
}
