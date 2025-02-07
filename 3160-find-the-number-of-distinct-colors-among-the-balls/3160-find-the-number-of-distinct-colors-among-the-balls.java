class Solution {
  public int[] queryResults(int limit, int[][] queries) {
    int[] answers = new int[queries.length];
    Map<Integer, Integer> colorMap = new HashMap<>();
    Map<Integer, Integer> balls = new HashMap<>();

    int idx = 0;
    for (int[] query : queries) {
      int ball = query[0];
      int color = query[1];

      Optional.ofNullable(balls.get(ball))
        .ifPresent(prevColor -> {
        colorMap.merge(prevColor, 1, (a, b) -> a - b);
        if (colorMap.get(prevColor) == 0) {
          colorMap.remove(prevColor);
        }
      });

      colorMap.merge(color, 1, Integer::sum);
      answers[idx++] = colorMap.size();
      balls.put(ball, color);
    }

    return answers;
  }
}