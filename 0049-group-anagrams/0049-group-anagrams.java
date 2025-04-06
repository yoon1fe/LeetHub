class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    List<List<String>> answer = new ArrayList<>();

    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sortedStr = new String(chars);
      map.merge(sortedStr, new ArrayList<>(List.of(str)), (oldList, newList) -> {
        oldList.addAll(newList);
        return oldList;
      });
    }
    
    for (String key : map.keySet()) {
      answer.add(map.get(key));
    }

    return answer;
  }
}