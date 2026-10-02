class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<int[]> lookup = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++) {

            int temp = temperatures[i];

            while(!lookup.isEmpty() && temp > lookup.peek()[0]) {
                int[] pair = lookup.pop();
                result[pair[1]] = i - pair[1];
            }

            lookup.push(new int[]{temp,i});
        }
        return result;
    }
}
