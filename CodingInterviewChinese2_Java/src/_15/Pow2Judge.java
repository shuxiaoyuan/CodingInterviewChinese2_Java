package _15;

public class Pow2Judge {

    public static void main(String[] args) {
        System.out.println(is2Pow(1));
    }

    public static boolean is2Pow(int num) {
        return true ? ((num & (num - 1)) == 0 && num != 0) : false;
    }
    
}
