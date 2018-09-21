package _17;


/**
 * 面试题17：打印从1到最大的n位数
 * P114
 */
public class Print1ToMaxOfNDigits {

    public static void main(String[] args) {
        print1ToMax(2);
    }
    
    public static void print1ToMax(int n) {
        //byAdd(n);
        byRecursively(n);
    }

    public static void byAdd(int n) {
        if(n <= 0) {
            return;
        }
        char[] number = new char[n];
        for(int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        while(!increment(number)) {
            printNumber(number);
        }
    }
    
    public static boolean increment(char[] number) {
        boolean isOverflow = false;
        int takeOver = 0;
        int sum = 0;
        for(int i = number.length - 1; i >= 0; i--) {
            sum = number[i] - '0' + takeOver;
            if(i == number.length - 1) {
                sum++;
            }
            if(sum >= 10) {
                if(i == 0) {
                    isOverflow = true;
                }
                else {
                    sum -= 10;
                    takeOver = 1;
                    number[i] = (char)('0' + sum);
                }
            }
            else {
                number[i] = (char)('0' + sum);
                break;
            }
        }
        return isOverflow;
    }
    
    public static void byRecursively(int n) {
        if(n <= 0) {
            return;
        }
        char[] number = new char[n];
        for(int i = 0; i < n; i++) {
            number[i] = '0';
        }
        for(int i = 0; i < 10; i++) {
            number[0] = (char)('0' + i);
            printRecursively(number, 0);
        }
    }
    
    public static void printRecursively(char[] number, int index) {
        if(index == number.length - 1) {
            printNumber(number);
            return;
        }
        for(int i = 0; i < 10; i++) {
            number[index + 1] = (char)('0' + i);
            printRecursively(number, index + 1);
        }
    }
    
    public static void printNumber(char[] number) {
        boolean isBegin0 = true;
        for(int i = 0; i < number.length; i++) {
            if(isBegin0) {
                if(number[i] != '0') {
                    isBegin0 = false;
                }
                else if(i == number.length - 1) {
                    return;
                }
            }
            if(!isBegin0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
    
}
