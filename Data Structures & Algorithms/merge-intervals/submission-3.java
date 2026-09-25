class Solution {
    public int[][] merge(int[][] intervals) {

        //[[1,3],[1,5],[6,7]]
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        List<int[]> mergeOverlapping = new ArrayList<>();

        for(int[] interval: intervals) {

            if(mergeOverlapping.isEmpty()) {
                mergeOverlapping.add(interval);
                continue;
            }

            int[] lastRange = mergeOverlapping.getLast();

            if(interval[0] <= lastRange[1]) {
                lastRange[1] = Math.max(interval[1], lastRange[1]);
            } else {
                mergeOverlapping.add(interval);
            }
        }

        return mergeOverlapping.toArray(new int[mergeOverlapping.size()][]);
        
    }
}
