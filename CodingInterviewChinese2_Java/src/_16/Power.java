package _16;


/**
 * 数值的整数次方
 * P110
 */
public class Power {

    public static boolean gInvalidInput = false;
    
    public static void main(String[] args) {
        System.out.println(power(2, 3) + " " + gInvalidInput);
        System.out.println(power(2, 0) + " " + gInvalidInput);
        System.out.println(power(2, -3) + " " + gInvalidInput);
        System.out.println(power(-2, 3) + " " + gInvalidInput);
        System.out.println(power(-2, -3) + " " + gInvalidInput);
        System.out.println(power(0, -1) + " " + gInvalidInput);
        System.out.println(power(0, 0) + " " + gInvalidInput);
        System.out.println(power(0, 1) + " " + gInvalidInput);
    }
    
    public static double power(double base, int exponent) {
        gInvalidInput = false;
        if(equal(base, 0) && exponent <= 0) {
            gInvalidInput = true;
            return 0.0;
        }
        long absExponent = exponent >= 0 ? exponent : -exponent;
        double result = powerCoreBetter(base, absExponent);
        if(exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }
    
    public static boolean equal(double a, double b) {
        if(a - b > -0.0000001 && a - b < 0.0000001) {
            return true;
        }
        return false;
    }
    
    public static double powerCore(double base, long absExponent) {
        double result = 1.0;
        for(int i = 0; i < absExponent; i++) {
            result *= base;
        }
        return result;
    }
    
    public static double powerCoreBetter(double base, long absExponent) {
        if(absExponent == 0) {
            return 1.0;
        }
        if(absExponent == 1) {
            return base;
        }
        double result = powerCoreBetter(base, absExponent >> 1);
        result *= result;
        if((absExponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }
    
}
