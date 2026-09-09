class Solution {
    public int[] twoSum(int[] numbers, int target) {

        for(int i = 0; i<numbers.length-1; i++) {

            int temp = target - numbers[i];
            int l= i+1, r = numbers.length-1;

            while(l<=r) {

                int mid = (l+r)/2;

                if(numbers[mid] == temp) {
                    return new int[]{i+1, mid+1};
                } else if(numbers[mid] < temp) {
                    l = mid +1;
                } else {
                    r = mid-1;
                }
            }
        }
        return new int[0];
    }
}
