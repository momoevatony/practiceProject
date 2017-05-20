package course2_IntegerArray;

import java.util.Arrays;

public class ThreeSumClosest {
	
	//accepted 5.19.2017 2280ms
	public int threeSumClosest(int[] numbers, int target) {
        // write your code here
		Arrays.sort(numbers);
		int result = numbers[0] + numbers[1] + numbers[2];
		for (int i = 0; i < numbers.length - 2; i++) {
			int curr = twoSumClosest(numbers, i+1, numbers.length - 1, target - numbers[i]);
			curr += numbers[i];
			if (Math.abs(curr - target) < Math.abs(result - target)) {
				result = curr;
			}
		}
		return result;
    }
	
	public int twoSumClosest(int[] numbers, int left, int right, int target) {
		int result = numbers[left] + numbers[right];
		while (left < right) {
			int curr = numbers[left] + numbers[right];
			if (Math.abs(curr - target) < Math.abs(result - target)) {
				result = curr;
			}
			if (curr < target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}
}
