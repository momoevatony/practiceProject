package course7;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	
	//Accepted 5.2.2017 1108ms
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        if (numbers == null || numbers.length < 3) {
            return new ArrayList<>();
        }
        
        Arrays.sort(numbers);
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && i < numbers.length - 2 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            helper(list, numbers, i);
        }
        
        return list;
    }
    
    private void helper (ArrayList<ArrayList<Integer>> list, int[] numbers, int index) {
        
        int target = 0 - numbers[index];
        int left = index + 1;
        int right = numbers.length - 1;
        
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                ArrayList<Integer> currList = new ArrayList<>();
                currList.add(numbers[index]);
                currList.add(numbers[left]);
                currList.add(numbers[right]);
                list.add(new ArrayList<Integer>(currList));
                left++;
                right--;
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
