class Solution {
    
    class Dir {
        int y, x;
        Dir(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int curColor = image[sr][sc];
        Queue<Dir> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        queue.offer(new Dir(sr, sc));
        visited[sr][sc] = true;
        image[sr][sc] = newColor;
        
        while (!queue.isEmpty()) {
            Dir cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                Dir next = new Dir(cur.y + dy[i], cur.x + dx[i]);
                
                if (!isIn(next, m, n) || image[next.y][next.x] != curColor || visited[next.y][next.x]) continue;

                image[next.y][next.x] = newColor;
                visited[next.y][next.x] = true;
                queue.offer(next);
            }
        }
        
        return image;
    }
    
    private boolean isIn(Dir c, int m, int n) {
        return 0 <= c.y && c.y < m && 0 <= c.x && c.x < n;
    }
}