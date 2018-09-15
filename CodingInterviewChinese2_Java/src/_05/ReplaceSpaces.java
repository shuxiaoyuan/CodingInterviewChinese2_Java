package _05;


/**
 * 替换空格
 * P51
 * 用 C/C++ 的风格写才符合原书思想
 * 不过原书思想也不难
 * 此处仅当练习 Java 语法了 2333
 */
public class ReplaceSpaces {

    public static String replaceSpace(StringBuffer str) {
        if(str == null || str.toString().equals("")) {
            return "Error";
        }
        
        return str.toString().replace(" ", "%20");
    }
    
    public static void main(String[] args) {
        StringBuffer testCase1 = new StringBuffer(" we are happy");     // 开头有空格
        StringBuffer testCase2 = new StringBuffer("we are happy ");     // 末尾有空格
        StringBuffer testCase3 = new StringBuffer("we  are  happy");    // 有连续空格
        StringBuffer testCase4 = new StringBuffer("wearehappy");        // 没有空格
        StringBuffer testCase5 = new StringBuffer(" ");                 // 只有一个空格
        StringBuffer testCase6 = new StringBuffer("");                  // 空串
        StringBuffer testCase7 = null;                                  // null
        
        System.out.println("testCase1:" + replaceSpace(testCase1));
        System.out.println("testCase2:" + replaceSpace(testCase2));
        System.out.println("testCase3:" + replaceSpace(testCase3));
        System.out.println("testCase4:" + replaceSpace(testCase4));
        System.out.println("testCase5:" + replaceSpace(testCase5));
        System.out.println("testCase6:" + replaceSpace(testCase6));
        System.out.println("testCase7:" + replaceSpace(testCase7));
    }

}
