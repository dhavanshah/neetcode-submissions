class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        //using the max value here coz if it taks an hour for
        //koko to eat the max number of bananas then other
        //rates would be straightforward to achieve
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while(l <= r) {

            //since we need to find the k, we perform
            //binary search on k's values 1 to max(piles)
            int totalHours = 0;
            int k = (l + r)/2;

            for(int p : piles) {

                //total hours would be sum of all the times
                //it would take koko to eat bananas.
                totalHours += Math.ceil(((double)p)/k);

            }
            //if total hours amount to under h we record the k
            //then again try to find a k which is lesser than
            //the recorded
            if(totalHours <= h) {
                res = k;
                r = k-1;
            } else {
                l = k+1;
            }

        }
        return res;
    }

    // private int findMax(int[] piles) {

    //     int max = piles[0];

    //     for(int nums : piles){

    //         max = Math.max(nums, max);
    //     }
    //     return max;
    // }
}
