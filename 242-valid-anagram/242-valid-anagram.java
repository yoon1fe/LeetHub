class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    
    Map<Character, Integer> sMap = makeMap(s);
    Map<Character, Integer> tMap = makeMap(t);
    
    return sMap.equals(tMap);
  }
  
  Map<Character, Integer> makeMap(String s) {
    Map<Character, Integer> map = new TreeMap<>();
    
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    return map;
  }
}