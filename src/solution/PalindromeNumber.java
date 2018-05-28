package solution;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {

        // �������ǻط�����
        if (x < 0) {
            return false;
        }

        // ������ת���ֵ��Ϊ�˲�ʹ���������long
        long reverse = 0;
        int tmp = x;

        // ����ת���ֵ
        while (tmp != 0) {
            reverse = reverse * 10 + tmp % 10;
            tmp /= 10;
        }
        // �ж��Ƿ��ǻ�������
        return x == reverse;
    }
	
	public static void main(String[] args) {
		PalindromeNumber solution = new PalindromeNumber();
		System.out.println(solution.isPalindrome(232));
	}
}
