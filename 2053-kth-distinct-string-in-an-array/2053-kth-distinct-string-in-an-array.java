class Solution {
  public String kthDistinct(String[] arr, int k) {
    Map<String, Integer> map = new LinkedHashMap<>();

    for (String str : arr) {
      map.put(str, map.getOrDefault(str, 0) + 1);
    }

    List<String> list = map.entrySet().stream()
      .filter(entry -> entry.getValue() == 1)
      .map(Map.Entry::getKey)
      .toList();

    return list.size() < k ? "" : list.get(k - 1);
  }
}