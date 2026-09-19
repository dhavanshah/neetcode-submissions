class Solution {
    public int trap(int[] height) {
        
        int l = 0;
        int r = height.length - 1;
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;

        while(l < r) {

            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);

            if(leftMax < rightMax) {

                result += leftMax - height[l];
                l++;

            }else {
                result += rightMax - height[r];
                r--;
            }
        }
        return result; 
    }
}
