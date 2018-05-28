package solution;

public class ReverseInteger {
	public int reverse(int x) {
        long tmp = x;
        // 防止结果溢出
        long result = 0;

        while (tmp != 0) {
            result = result * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        // 溢出判断
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            result = 0;
        }

        return (int) result;
    }
	
	public static void main(String[] args) {
		ReverseInteger solution = new ReverseInteger();
		System.out.println(solution.reverse(789));
	}
}
