public class SearchInsert {
    
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String args[]) {
        int[] test1 = {1, 3, 5, 6};
        int[] test2 = {1, 6, 8, 9, 10, 23};

        System.out.println(searchInsert(test1, 5)); // 2
        System.out.println(searchInsert(test1, 2)); // 1
        System.out.println(searchInsert(test1, 7)); // 4
        System.out.println(searchInsert(test1, 4)); // 2
        System.out.println(searchInsert(test2, 15)); // 5
        System.out.println(searchInsert(test2, 9)); // 3
        System.out.println(searchInsert(test2, 27)); // 6
    }
}
