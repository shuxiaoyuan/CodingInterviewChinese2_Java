package _11;


/**
 * 面试题11：旋转数组的最小数字
 * P82
 */

public class MinNumberInRotatedArray {

    public static void main(String[] args) {
        int[] numbers1 = {4, 5, 6, 1, 2, 3};
        int[] numbers2 = {1, 1, 1, 0, 1};
        int[] numbers3 = {};
        int[] numbers4 = null;
        
        System.out.println("numbers1:" + minNumber(numbers1));
        System.out.println("numbers2:" + minNumber(numbers2));
        //System.out.println("numbers3:" + minNumber(numbers3));
        //System.out.println("numbers4:" + minNumber(numbers4));
        
    }

    public static int minNumber(int[] numbers) {
        if(numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("numbers is invalid!");
        }
        
        int index1 = 0;
        int index2 = numbers.length - 1;
        int indexm = index1;        // 旋转个数为 0 的情况
        
        while(numbers[index1] >= numbers[index2]) {
            if(index2 - index1 == 1) {
                indexm = index2;
                break;
            }
            indexm = (index1 + index2) / 2;
            
            if(numbers[index1] == numbers[index2] &&
                    numbers[index1] == numbers[indexm]) {
                return sequentialSearch(numbers, index1, index2);
            }
            
            if(numbers[indexm] >= index1) {
                index1 = indexm;
            }
            else if(numbers[indexm] <= index2) {
                index2 = indexm;
            }
        }
        return numbers[indexm];
    }
    
    public static int sequentialSearch(int[] numbers, int index1, int index2) {
        int result = numbers[index1];
        for(int i = index1 + 1; i <= index2; i++) {
            if(numbers[i] < result) {
                result = numbers[i];
            }
        }
        return result;
    }
    
}
