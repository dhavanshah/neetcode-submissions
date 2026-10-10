class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        //[1,4,3,2]
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int result = high;

        while(low <= high) {

            int totalHours = 0;
            int k = (low + high) / 2;

            for(int p : piles) {
                totalHours += Math.ceil((double)p/k);
            }

            if(totalHours <= h) {
                result = k;
                high = k-1;
            } else {
                low = k+1;
            }
        }
        return result;
    }
}
