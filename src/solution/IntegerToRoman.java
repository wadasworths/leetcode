package solution;

public class IntegerToRoman {
	/**
	 * ����һ�����֣�����ת��һ���������֣������������[1, 3999]֮��
	 */
	
	public String intToRoman(int num) {
		String[][] base = new String[][]{
            {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, // ��λ�ı�ʾ
            {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, // ʮλ�ı�ʾ
            {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, // �ٱ��ı�ʾ
            {"M", "MM", "MMM", "", "", "", "", "", ""}}; // ǧλ�ı�ʾ
            
        String results = "";
        
		for (int i = 0; num != 0; num /= 10, i++) {
            // �����Ϊ0��˵�������λ����ֵ��Ҫ������Ӳ���
            if (num % 10 != 0) {
                // ƴ�ӽ��
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
