class Solution {

    private static final int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int numIslands(char[][] grid) {

        //BFS
        //1. Traverse each cell in the grid
        //2. If you come across a 1 then increment island count
        //and perform BFS on that cell
        //3. During BFS, push the cell on a queue and mark that cell
        //as "0"
        //4. While the queue has items:
        //5. Pop the cell
        //6. Explore its adjacent cells(up, down, left, right)
        //7. Found a "1"? Mark it as "0" and add it to the queue
        //8. Similarly, scan the grid fully
        //9. Return the number of islands

        int ROWS = grid.length;
        int COLS = grid[0].length;

        int islands = 0;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {

                if(grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
        
    }

    private void bfs(char[][] grid, int r, int c) {

        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = '0';
        q.add(new int[]{r,c});

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir : directions) {

                int ar = row + dir[0];
                int ac = col + dir[1];

                if(ar >= 0 && ac >= 0 && ar < grid.length &&
                ac < grid[0].length && grid[ar][ac] == '1') {
                    grid[ar][ac] = '0';
                    q.add(new int[]{ar,ac});
                }
            }
        }
    }
}
