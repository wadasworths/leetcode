package solution;

public class ZigZagConversion {
	public String convert(String s, int nRows) {

        if (s == null || s.length() <= nRows || nRows == 1) {
            return s;
        }

        int index = s.length();
        int rowLength = 0; // �����еĳ��ȣ�����������ַ�

        int slash = nRows - 2; // һ��б�߳�ȥ��β��ռ�õ�����

        while (index > 0) {
            // ���ε�һ��
            index -= nRows;
            rowLength++;

            // б�ŵ�����
            for (int i = 0; i < slash && index > 0; i++) {
                rowLength++;
                index--;
            }
        }

        char[] result = new char[nRows * rowLength]; // �����������飬���һ�����ڱ��滻�з�
        for (int i = 0; i < result.length; i++) { // ��ʼ��Ϊ�ո�
            result[i] = ' ';
        }

        int curColumn = 0; // ��ǰ���������
        index = 0;
        while (index < s.length()) {
            // ��������
            for (int i = 0; i < nRows && index < s.length(); i++) {
                result[rowLength * i + curColumn] = s.charAt(index);
                index++;
            }
            curColumn++;
            // ����б��
            for (int i = nRows - 2; i > 0 && index < s.length(); i--) {
                result[rowLength * i + curColumn] = s.charAt(index);
                curColumn++;
                index++;
            }
        }

        // ���ַ�������н��ղ���
        index = 0;
        while (index < s.length() && result[index] != ' ') { // �ҵ�һ���ǿո���ַ�λ��
            index++;
        }
        int next = index + 1;
        while (index < s.length()) {
            while (next < result.length && result[next] == ' ') { // �Ҳ��ǿո��Ԫ��
                next++;
            }
            result[index] = result[next];
            index++;
            next++;
        }
        return new String(result, 0, index);
    }
	
	public static void main(String[] args) {
		ZigZagConversion solution = new ZigZagConversion();
		System.out.print(solution.convert("PAYPALISHIRING", 4));
	}
}
