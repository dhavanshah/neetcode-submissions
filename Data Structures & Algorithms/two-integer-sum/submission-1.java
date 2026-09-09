class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> visited = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {

            int ans = target - nums[i];
            if(visited.containsKey(ans)) {
                return new int[] {visited.get(ans),i};
            }
            visited.put(nums[i], i);
            
        }
        return null;
        
    }
}
