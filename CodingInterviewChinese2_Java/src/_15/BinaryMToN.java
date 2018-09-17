package _15;


/**
 * 面试题15：二进制中1的个数
 * P103
 */
public class BinaryMToN {

    public static void main(String[] args) {
        System.out.println(binaryBits(10, 13));
    }
    
    public static int binaryBits(int m, int n) {
        int tmp = m ^ n;
        int count = 0;
        while(tmp != 0) {
            count++;
            tmp = tmp & (tmp - 1);
        }
        return count;
    }

}
