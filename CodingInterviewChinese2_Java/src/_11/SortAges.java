package _11;

import java.util.Arrays;

/**
 * 面试题11：对年龄排序
 * P81
 */

public class SortAges {

    public static void main(String[] args) {
        int[] ages1 = {20, 19, 35, 25};
        int[] ages2 = {25, 23, 120, 6};
        int[] ages3 = {};
        int[] ages4 = null;
        
        sortAges(ages1);
        System.out.println(Arrays.toString(ages1));
        //sortAges(ages2);
        //System.out.println(Arrays.toString(ages2));
        sortAges(ages3);
        System.out.println(Arrays.toString(ages3));
        //sortAges(ages4);
        //System.out.println(Arrays.toString(ages4));
    }

    public static void sortAges(int[] ages) {
        if(ages == null) {
            throw new NullPointerException("ages is null!");
        }
        
        int oldest = 99;
        int[] ageTimes = new int[oldest+1];
        for(int i = 0; i < ages.length; i++) {
            if(ages[i] <= 0 || ages[i] > oldest) {
                throw new RuntimeException("age is illegal!");
            }
            ageTimes[ages[i]]++;
        }
        int index = 0;
        for(int i = 0; i <= oldest; i++) {
            for(int j = 0; j < ageTimes[i]; j++) {
                ages[index] = i;
                index++;
            }
        }
    }
    
}
