import java.util.*;

public class AddThreeNumbers {
	public static List<List<Integer>> add(int[] nums) {
		// copy the input int array
		int[] arr = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = nums[i];
		}
		Arrays.sort(arr);

		List<List<Integer>> output = new ArrayList<>();

		for (int i = 0; i < arr.length - 2; i++) {
				int low = i + 1;
				int high = arr.length - 1;
				int sum = -arr[i];
			if (i == 0 || arr[i] != arr[i - 1]) {
				while (low < high) {
					if (arr[low] + arr[high] == sum) {
						output.add(Arrays.asList(arr[i], arr[low], arr[high]));
						low++;
						high--;
						while (low < high && arr[low] == arr[low - 1]) low++;
						while (low < high && arr[high] == arr[high + 1]) high--;
					}
					else if (arr[low] + arr[high] > sum) {
						high--;
					}
					else {
						low++;
					}
				}
			}
		}
		return output;
	}

	public static void main(String args[]) {
		int[] test1 = new int[] {-1,0,1,2,-1,-4};
		int[] test2 = new int[] {0,0,0};
		int [] test3 = new int[] {-2,0,1,1,2};
		int [] test4 = new int[] {-7,-3,-8,-1,-6,-4,0,3,7,5,3,1,2,7,4,2,12,0,7,4,-3};
		System.out.println(add(test1));
		System.out.println(add(test2));
		System.out.println(add(test3));
		System.out.println(add(test4));
	}
}
