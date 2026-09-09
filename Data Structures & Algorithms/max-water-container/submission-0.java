class Solution {
    public int maxArea(int[] heights) {

        int l = 0;
        int r = heights.length-1;
        int maxArea = 0;

        while(l < r) {
            int area = 0;

            if(heights[l] <= heights[r]) {

                area = heights[l] * (r-l);
                maxArea = Math.max(area, maxArea);
                l++;

            } else {
                area = heights[r] * (r-l);
                maxArea = Math.max(area, maxArea);
                r--;
            }
        }
        return maxArea;
        
    }
}
