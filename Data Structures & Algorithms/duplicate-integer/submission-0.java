class Solution {
    public boolean hasDuplicate(int[] nums) {

        Map<Integer, Integer> visited = new HashMap<>();

        for(int n : nums) {

            if(visited.containsKey(n)){
                return true;
            }
            visited.put(n, visited.getOrDefault(n,0)+1);
        }
        return false;
    }
}