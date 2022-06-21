class Solution {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    Arrays.sort(arr1);
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int[] answer = new int[arr1.length];
    
    for (int item : arr2) {
      map.put(item, 0);
    }
    
    for (int item : arr1) {
      map.put(item, map.getOrDefault(item, 0) + 1);
    }
    
    int idx = 0;
    for (int key : map.keySet()) {
      for (int i = 0; i < map.get(key); i++) {
        answer[idx++] = key;
      }
    }
        
    return answer;
  }
}