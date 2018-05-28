package solution;

public class StringToInteger {
	 public int atoi(String str) {

	        if (str == null || str.length() == 0) {
//	            throw new NumberFormatException("Invalid input string: " + str);
	            return 0;
	        }

	        // ����ַ����Կո�ʼ
	        int start = 0; //�ӿ�ʼ�ҵ�һ�����ǿո����
	        boolean positive = true; // �Ƿ�Ϊ����Ĭ��Ϊtrue

	        if (str.charAt(start) == ' ') {
	            while (str.charAt(start) == ' ') {
	                start++;
	                if (start >= str.length()) { // �����ȫ�ǿո�
//	                    throw new NumberFormatException("Invalid input string: " + str);
	                    return 0;
	                }
	            }
	        }

	        if (str.charAt(start) == '-') { // ��һ���ǿհ��ַ���-
	            positive = false;
	            start++;
	        } else if (str.charAt(start) == '+') {// ��һ���ǿհ��ַ���+
	            start++;
	        } else if (str.charAt(start) >= '0' && str.charAt(start) <= '9') { // ��һ���ǿհ��ַ�������
	            return cal(str, start, true);
	        } else { // ����������׳��쳣
//	            throw new NumberFormatException("Invalid input string: " + str);
	            return 0;
	        }


	        if (start >= str.length()) { // ��һ���ǿհ��ַ���+����-��Ҳ�����һ���ַ�
//	            throw new NumberFormatException("Invalid input string: " + str);
	            return 0;
	        }

	        if (str.charAt(start) > '9' || str.charAt(start) < '0') { // +����-����ӵĲ�������
//	            throw new NumberFormatException("Invalid input string: " + str);
	            return 0;
	        } else {
	            return cal(str, start, positive);
	        }
	    }

	    private int cal(String str, int start, boolean positive) {

	        long result = 0;
	        while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9') {
	            result = result * 10 + (str.charAt(start) - '0');

	            if (positive) { // ���������
	                if (result > Integer.MAX_VALUE) {
//	                    throw new NumberFormatException("Invalid input string: " + str);
	                    return Integer.MAX_VALUE;
	                }

	            } else {
	                if (-result < Integer.MIN_VALUE) {
//	                    throw new NumberFormatException("Invalid input string: " + str);
	                    return Integer.MIN_VALUE;
	                }
	            }

	            start++;
	        }

	        if (positive) {
	            return (int) result;
	        } else {
	            return (int) -result;
	        }
	    }
	    
	    public static void main(String[] args) {
	    	StringToInteger solution = new StringToInteger();
	    	System.out.println(solution.atoi("-91283472332"));
		}
}
