package _15;


/**
 * 面试题15：改变 m 的二进制位数得到 n
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
