class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        List<List<Integer>> bucket = new ArrayList<>();

        for(int i=0; i<=nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        for(int num : nums) {

            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> ele : freq.entrySet()) {

            bucket.get(ele.getValue()).add(ele.getKey());
        }
        
        int[] ans = new int[k];
        int index = 0;
        for(int i=bucket.size()-1; i>0; i--) {
            for(int n : bucket.get(i)) {
                ans[index] = n;
                index++;

                if(index == k) {
                    return ans;
                }
            }
            
        }
        return ans;
    }
}
