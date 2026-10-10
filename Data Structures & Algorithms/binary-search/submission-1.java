class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length-1, target, nums);
    }

    public int binarySearch(int l, int r, int target, int[] nums) {

        if(l > r) {
            return -1;
        }

        int m = (l + r) / 2;

        if(nums[m] == target) {
            return m;
        } else if(nums[m] > target) {
            return binarySearch(l, m-1, target, nums);
        } else {
            return binarySearch(m+1, r, target, nums);
        }
    }
}
