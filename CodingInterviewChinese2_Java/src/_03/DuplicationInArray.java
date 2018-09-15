package _03;

import java.util.Arrays;


/**
 * 面试题3：数组中重复的数字
 * P39
 */
public class DuplicationInArray {
    
    public static void main(String[] args) {
        // 长度为 n 的数组里包含一个或多个重复的数字
        int[] testCase1 = {2, 3, 1, 0, 2, 5, 3};
        System.out.println("testCase1:" + getDuplication(testCase1));
        
        // 数组中不含重复的数字
        int[] testCase2 = {2, 3, 1, 0, 5, 4};
        System.out.println("testCase2:" + getDuplication(testCase2));
        
        // 空指针
        int[] testCase3 = null;
        System.out.println("testCase3:" + getDuplication(testCase3));
        
        // 长度为 n 的数组中包含 0~n-1 之外的数字
        int[] testCase4 = {2, 3, 1, 0, 2, 6};
        System.out.println("testCase4:" + getDuplication(testCase4));
    }

    private static int getDuplication(int[] numbers) {
        if(numbers == null) {
            return -1;
        }
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] < 0 || numbers[i] > numbers.length-1) {
                return -1;
            }
        }
        
        //return byHash(numbers);
        //return bySort(numbers);
        return bySwap(numbers);
    }

    // 哈希表方式，时间 O(n) 空间 O(n)，无需修改原数组
    private static int byHash(int[] numbers) {
        boolean[] tmp = new boolean[numbers.length]; 
        for(int n : numbers) {
            if(tmp[n]) {
                return n;
            }
            else {
                tmp[n] = true;
            }
        }
        return -1;
    }
    
    // 对原数组进行排序然后顺序查找，时间 O(nlogn) 空间 O(1)
    private static int bySort(int[] numbers) {
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] == numbers[i+1]) {
                return numbers[i];
            }
        }
        return -1;
    }
    
    // 交换原数组中的元素，时间 O(n) 空间 O(1)
    private static int bySwap(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            while(numbers[i] != i) {
                if(numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                int tmp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[tmp] = tmp;
            }
        }
        return -1;
    }
    
}
