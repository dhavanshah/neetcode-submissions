class Solution {
    public int maxArea(int[] heights) {

        int l = 0;
        int r = heights.length-1;
        int maxArea = 0;

        while(l < r) {
            int area = 0;

            area = (r-l) * Math.min(heights[l], heights[r]);

            if(heights[l] <= heights[r]) {
                l++;

            } else {
                r--;
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
        
    }
}
