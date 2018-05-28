package solution;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public static int[] twoSum(int[] numbers,int target) {
		int[] res = new int[2];
		HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < numbers.length; i++) {
			Integer a = nums.get(numbers[i]);
			if (a == null) {
				nums.put(numbers[i], i);
			}

			a = nums.get(target - numbers[i]);
			if (a != null && a < i ) {
				res[0] = a + 1;
                res[1] = i + 1;
                break;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 17;
		int[] result = twoSum(numbers, target);
		System.out.println(Arrays.toString(result));
	}
}
