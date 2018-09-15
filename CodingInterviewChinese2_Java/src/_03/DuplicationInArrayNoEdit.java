package _03;

/**
 * 面试题3：不修改数组找出重复的数字
 * P41
 */
public class DuplicationInArrayNoEdit {

    public static void main(String[] args) {
        // 长度为 n+1 的数组里包含一个或多个重复的数字
        int[] testCase1 = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println("testCase1:" + getDuplication(testCase1));
        
        // 空指针
        int[] testCase2 = null;
        System.out.println("testCase2:" + getDuplication(testCase2));
        
        // 长度为 n+1 的数组中包含 1~n 之外的数字
        int[] testCase3 = {2, 3, 5, 4, 3, 0, 6, 7};
        System.out.println("testCase3:" + getDuplication(testCase3));
    }

    public static int getDuplication(int[] numbers) {
        if(numbers == null) {
            return -1;
        }
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] < 1 || numbers[i] > numbers.length-1) {
                return -1;
            }
        }
        
        int start = 1;
        int end = numbers.length-1;
        while(start <= end) {
            int middle = start + (end - start) / 2;
            int n = getCount(numbers, start, middle);
            if(start == end) {
                if(n > 1) {
                    return start;
                }
                else {
                    break;
                }
            }
            if(n > middle-start+1) {
                end = middle;
            }
            else {
                start = middle + 1;
            }
        }
        return -1;
    }
    
    private static int getCount(int[] numbers, int start, int end) {
        int n = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] >= start && numbers[i] <= end) {
                n++;
            }
        }
        return n;
    }
    
}
