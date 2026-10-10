class Solution {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length-1;
        int result = nums[low];

        while(low <= high) {

            if(nums[low] < nums[high]) {
                result = Math.min(result, nums[low]);
                break;
            }

            int mid = (low+high)/2;
            result = Math.min(result, nums[mid]);

            if(nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
        
    }
}
