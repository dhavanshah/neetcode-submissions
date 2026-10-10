class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length-1;
        while(top <= bottom) {
            int mid = (top + bottom)/2;
            int[] row = matrix[mid];
            if(target >= row[0] && target <= row[row.length-1]) {
                return binarySearch(row, target);
            } else if(target > row[row.length-1]) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] row, int target) {
        
        int low = 0;
        int high = row.length - 1;

        while(low <= high) {

            int mid = (low + high) / 2;

            if(row[mid] == target) {
                return true;
            } else if(target < row[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
