class Solution {
  public int longestCommonPrefix(int[] arr1, int[] arr2) {
    int maxLength = 0;
    Set<String> set = new HashSet<>();
    for (int num : arr1) {
      List<String> prefix = makePrefix(num);
      set.addAll(prefix);
    }
    
    for (int num : arr2) {
      List<String> prefix = makePrefix(num);
      for (String target : prefix) {
        if (set.contains(target) && target.length() > maxLength) {
          maxLength = target.length();
        }
      }
    }

    return maxLength;
  }

  private List<String> makePrefix(int num) {
    String str = String.valueOf(num);
    List<String> list = new LinkedList<>();
    
    
    for (int i = 0; i < str.length(); i++) {
      list.add(str.substring(0, i + 1));
    }
    return list;
  }
}