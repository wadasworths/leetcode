package solution;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return null;
		}
		
		int min = Integer.MAX_VALUE;
		for (String str : strs) {
			if (str == null) {
				return null;
			}
			
			if (min > str.length()) {
				min = str.length();
			}
		}
		
		int i; // 记录最长前缀的字符数
        boolean flag;
        for (i = 0; i < min; i++) {
            flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                break;
            }
        }
        return strs[0].substring(0, i);
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix solution = new LongestCommonPrefix();
		String[] nums = {"flower","flow","floight"};
		
		System.out.println(solution.longestCommonPrefix(nums));
	}
}
