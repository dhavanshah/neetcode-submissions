class Solution {
    public int longestConsecutive(int[] nums) {

        //use hashset for lookup, convert the nums
        //array to hashset.
        //The idea here is to identify the start
        //of the sequence. The number is at the start
        //of a sequence if there is no immediate left
        //neighbour of it (this reduces the number of
        //comparisons)

        Set<Integer> lookup = new HashSet<>();
        int maxLength = 0;
        for(int n : nums) {

            lookup.add(n);
        }

        for(int num : nums) {

            if(!lookup.contains(num-1)) {
                int length = 0;
                while(lookup.contains(num + length)) {
                    length++;
                }
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
        
    }
}
