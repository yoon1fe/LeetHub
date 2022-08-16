class Solution {
  public int firstUniqChar(String s) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    int answer = -1;
    
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    
    for (Character key : map.keySet()) {
      if (map.get(key) >= 2) continue;
      
      answer = s.indexOf(key);
      break;
    }
    
    return answer;
  }
}