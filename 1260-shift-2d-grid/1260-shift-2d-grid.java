class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                deque.offerLast(grid[i][j]);
            }
        }
        
        for (int i = 0; i < k; i++) {
            deque.offerFirst(deque.pollLast());
        }
        
        for (int i = 0; i < grid.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                row.add(deque.pollFirst());
            }
            answer.add(row);
        }
        
        return answer;
    }
}