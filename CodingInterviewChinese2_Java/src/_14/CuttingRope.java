package _14;

public class CuttingRope {

    public static void main(String[] args) {
        System.out.println(maxProduct(8));
    }

    public static int maxProduct(int length) {
        //return byDP(length);
        return byGreedy(length);
    }
    
    public static int byDP(int length) {
        if(length < 2) {
            return 0;
        }
        if(length == 2) {
            return 1;
        }
        if(length == 3) {
            return 2;
        }
        
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        
        int max = 0;
        for(int i = 4; i <= length; i++) {
            for(int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if(product > max) {
                    max = product;
                }
            }
            products[i] = max;
        }
        return products[length];
    }
    
    
    public static int byGreedy(int length) {
        if(length < 2) {
            return 0;
        }
        if(length == 2) {
            return 1;
        }
        if(length == 3) {
            return 2;
        }
        
        int timesOf3 = length / 3;
        
        if(length - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        
        int timesOf2 = (length - timesOf3 * 3) / 2;
        
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
        
    }
    
}
