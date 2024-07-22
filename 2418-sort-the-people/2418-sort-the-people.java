class Solution {
  public static String[] sortPeople(String[] names, int[] heights) {
    Map<Integer, Integer> map = new HashMap<>();
    String[] answer = new String[names.length];

    for (int i = 0; i < names.length; i++) {
      map.put(i, heights[i]);
    }

    Integer[] sorted = map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
          }
        }))
        .map(Map.Entry::getKey)
        .toArray(Integer[]::new);

    for (int i = 0; i < names.length; i++) {
      answer[i] = names[sorted[i]];
    }

    return answer;
  }
}