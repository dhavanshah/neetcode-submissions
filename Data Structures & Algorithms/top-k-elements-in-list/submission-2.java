class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //idea is to perform bucket sort with a twist
        //here the indexes of an array would represent
        //the count of the numbers in the array,
        //the values would have a list of numbers
        //For eg: [[1],[2],[3,4,5]] here, 1 occurs one time
        //[3,4,5] occurs two times as it is at 2nd index
        //once this is populated we traverse the list
        //in reverse and add elements to result until its
        //length is k.

        Map<Integer, Integer> count = new HashMap<>();
        List<List<Integer>> freq = new ArrayList<>();

        for(int i=0; i<=nums.length; i++) {

            freq.add(new ArrayList<>());
        }

        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> ele : count.entrySet()) {

            freq.get(ele.getValue()).add(ele.getKey());

        }

        int[] result = new int[k];
        int index = 0;
        for(int i=freq.size()-1; i>0; i--) {
            for(int n : freq.get(i)) {
                result[index] = n;
                index++;
                if(index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
