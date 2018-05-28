package solution;

public class IntegerToRoman {
	/**
	 * 输入一个数字，将它转成一个罗马数字，输入的数字在[1, 3999]之间
	 */
	
	public String intToRoman(int num) {
		String[][] base = new String[][]{
            {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, // 个位的表示
            {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, // 十位的表示
            {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, // 百倍的表示
            {"M", "MM", "MMM", "", "", "", "", "", ""}}; // 千位的表示
            
        String results = "";
        
		for (int i = 0; num != 0; num /= 10, i++) {
            // 如果不为0，说明这个数位上有值，要进行相加操作
            if (num % 10 != 0) {
                // 拼接结果
                results = base[i][num % 10 - 1] + results;
            }
        }

        return results;
	}
	
	public static void main(String[] args) {
		IntegerToRoman solutioin = new IntegerToRoman();
		
		System.out.println(solutioin.intToRoman(232));
	}
}
