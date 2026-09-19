class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        //count the fresh oranges in the grid and fill the queue
        //with rotten oranges
        for(int r = 0; r < grid.length; r++) {

            for(int c = 0; c < grid[0].length; c++) {

                if(grid[r][c] == 1) {
                    fresh++;
                }

                if(grid[r][c] == 2) {
                    q.offer(new int[]{r,c});
                }
            }

        }

        //directions: [i,j-1],[i,j+1],[i-1,j],[i+1,j]
        while(q.size() > 0 && fresh > 0) {
            int size = q.size();
            for(int i=0; i<size; i++) {

                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if(c-1 >= 0 && c-1 < grid[0].length && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    q.offer(new int[]{r,c-1});
                    fresh--;
                }

                if(c+1 >= 0 && c+1 < grid[0].length && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    q.offer(new int[]{r,c+1});
                    fresh--;
                }

                if(r-1 >= 0 && r-1 < grid.length && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    q.offer(new int[]{r-1,c});
                    fresh--;
                }

                if(r+1 >= 0 && r+1 < grid.length && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    q.offer(new int[]{r+1,c});
                    fresh--;
                }
            }
            time++;

        }
        return fresh == 0 ? time : -1;
    }
}
