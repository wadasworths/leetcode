package solution;

import java.util.Arrays;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        boolean[] match = new boolean[s.length() + 1];
        Arrays.fill(match, false);
        match[s.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) == '*') {
                for (int j = s.length() - 1; j >= 0; j--)  {
                    match[j] = match[j] || match[j + 1]
                            && (p.charAt(i - 1) == '.' || s.charAt(j) == p.charAt(i - 1));
                }
                i--;
            } else {
                for (int j = 0; j < s.length(); j++) {
                    match[j] = match[j + 1]
                            && (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j));
                }

                match[s.length()] = false;
            }
        }
        return match[0];
    }

    // ����Ĵ�����ʱ�Ƚϳ�
    public boolean isMatch2(String s, String p) {
        // ���붼Ϊnull
        if (s == null && p == null) {
            return true;
        }
        // ��һ��Ϊnull
        else if (s == null || p == null) {
            return false;
        }

        return isMatch(s, 0, p, 0);
    }

    /**
     * ������ʽƥ��
     *
     * @param s    ƥ�䴮
     * @param sIdx ��ǰƥ���λ��
     * @param p    ģʽ��
     * @param pIdx ģʽ����ƥ��λ��
     * @return ƥ����
     */
    public boolean isMatch(String s, int sIdx, String p, int pIdx) {
        // ͬʱ�����Ե�ĩβ
        if (s.length() == sIdx && p.length() == pIdx) {
            return true;
        }
        // ��ƥ�䴮û�е���ĩβ��ģʽ���Ѿ�����ĩβ
        else if (s.length() != sIdx && p.length() == pIdx) {
            return false;
        }
        // �������
        else {
            // �����ǰƥ�����һ���ַ���*��
            if (pIdx < p.length() - 1 && p.charAt(pIdx + 1) == '*') {
                // ƥ�䴮δ�������ҵ�ǰ�ַ�ƥ�䣨�ַ���Ȼ�����.�ţ�
                if (sIdx < s.length() && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.')) {
                    return isMatch(s, sIdx + 1, p, pIdx + 2) // ƥ�䴮��ǰ�ƶ�һ���ַ���ֻƥ��һ�Σ�
                            || isMatch(s, sIdx + 1, p, pIdx) //  ƥ�䴮��ǰ�ƶ�һ���ַ�����һ��ƥ��ͬ���ģ�ģʽ����������
                            || isMatch(s, sIdx, p, pIdx + 2); // ����ƥ���ģʽ��
                } else {
                    // ����*
                    return isMatch(s, sIdx, p, pIdx + 2);
                }
            }

            // ƥ��һ���ַ�
            if (sIdx < s.length() && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.')) {
                return isMatch(s, sIdx + 1, p, pIdx + 1);
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
    	RegularExpressionMatching solution = new RegularExpressionMatching();
    	System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
	}
}
