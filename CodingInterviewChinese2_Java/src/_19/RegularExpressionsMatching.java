package _19;


/**
 * 面试题19：正则表达式匹配
 * P124
 */
public class RegularExpressionsMatching {

	public static void main(String[] args) {
		// String str = "aaa";
		// String str = "";
		String str = null;
		// String pattern = "a.a";
		// String pattern = "ab*ac*a";
		// String pattern = "aa.a";
		// String pattern = "ab*a";
		// String pattern = "";
		String pattern = null;
		System.out.println(match(str, pattern));
	}

	public static boolean match(String str, String pattern) {
		if(str == null || pattern == null) {
			return false;
		}
		return matchCore(str, 0, pattern, 0);
	}
	
	public static boolean matchCore(String str, int strPos, String pattern, int patPos) {
		if(strPos >= str.length() && patPos >= pattern.length()) {
			return true;
		}
		if(strPos >= str.length() || patPos >= pattern.length()) {
			return false;
		}
		if(patPos+1 < pattern.length() && pattern.charAt(patPos+1) == '*') {
			if(str.charAt(strPos) == pattern.charAt(patPos) || 
					pattern.charAt(patPos) == '.') {
				return matchCore(str, strPos+1, pattern, patPos+2) || 
					   matchCore(str, strPos+1, pattern, patPos) ||
					   matchCore(str, strPos, pattern, patPos+2);
			}
			else {
				return matchCore(str, strPos, pattern, patPos+2);
			}
		}
		if(str.charAt(strPos) == pattern.charAt(patPos) || pattern.charAt(patPos) == '.') {
			return matchCore(str, strPos+1, pattern, patPos+1);
		}
		return false;
	}
	
}
