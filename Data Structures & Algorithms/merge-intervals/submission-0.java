class Solution {
    public int[][] merge(int[][] intervals) {

        //sorting this based on the start time
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        List<int[]> mergedOverlappingIntervals = new ArrayList<>(); 
        
        //mergedOverlappingIntervals.add(intervals[0]);
        for(int[] interval : intervals) {

            if(mergedOverlappingIntervals.isEmpty()) {
                mergedOverlappingIntervals.add(interval);
                continue;
            }
            
            int[] lastRange = mergedOverlappingIntervals.getLast();
            if(interval[0] <= lastRange[1]) {

                mergedOverlappingIntervals.getLast()[1] = Math.max(lastRange[1], interval[1]);

            } else {
                mergedOverlappingIntervals.add(interval);
            }
        }
        return mergedOverlappingIntervals.toArray(new int[mergedOverlappingIntervals.size()][]);
    }
}
