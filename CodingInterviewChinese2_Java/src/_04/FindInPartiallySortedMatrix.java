package _04;


/**
 * 二维数组中的查找
 * P44
 */
public class FindInPartiallySortedMatrix {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13}
        };
        
        int test_case1 = 1;     // 最小值
        int test_case2 = 13;    // 最大值
        int test_case3 = 7;     // 介于最大值最小值之间
        int test_case4 = 0;     // 小于最小值
        int test_case5 = 15;    // 大于最大值
        int test_case6 = 11;    // 介于最大值最小值之间，但没有这个数字
        
        System.out.println("test_case1: " + Find(test_case1, arr));
        System.out.println("test_case2: " + Find(test_case2, arr));
        System.out.println("test_case3: " + Find(test_case3, arr));
        System.out.println("test_case4: " + Find(test_case4, arr));
        System.out.println("test_case5: " + Find(test_case5, arr));
        System.out.println("test_case6: " + Find(test_case6, arr));
    }

    public static boolean Find(int target, int[][] array) {
        int startRow = 0;
        int endRow = array.length - 1;
        int startColumn = 0;
        int endColumn = array[0].length - 1;
        while(startRow <= endRow && endColumn >= startColumn) {
            if(array[startRow][endColumn] < target) {
                startRow++;
            }
            else if(array[startRow][endColumn] > target) {
                endColumn--;
            }
            else if(array[startRow][endColumn] == target) {
                return true;
            }
        }
        return false;
    }
    
}
