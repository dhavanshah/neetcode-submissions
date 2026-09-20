class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = findMax(piles);//Arrays.stream(piles).max().getAsInt();
        int res = r;

        while(l <= r) {

            int totalHours = 0;
            int k = (l + r)/2;

            for(int p : piles) {

                totalHours += Math.ceil(((double)p)/k);

            }
            if(totalHours <= h) {
                res = k;
                r = k-1;
            } else {
                l = k+1;
            }

        }
        return res;
    }

    private int findMax(int[] piles) {

        int max = piles[0];

        for(int nums : piles){

            max = Math.max(nums, max);
        }
        return max;
    }
}
