class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> look = new HashSet<>();
        int maxLength = 0;

        for(int n : nums) {

            look.add(n);

        }

        for(int num : nums) {


            if(!look.contains(num-1)) {
                int length = 0;
                while(look.contains(num + length)) {
                    length += 1;

                }
            maxLength = Math.max(maxLength, length);

            }

        }
        return maxLength;
        
    }
}

