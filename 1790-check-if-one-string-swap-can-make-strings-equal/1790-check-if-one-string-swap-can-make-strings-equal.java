class Solution {
  public boolean areAlmostEqual(String s1, String s2) {
    Map<Character, Integer> map1 = new HashMap<>(); // k -> 3
    Map<Character, Integer> map2 = new HashMap<>(); // a -> 3

    for (char c : s1.toCharArray()) {
      map1.put(c, map1.getOrDefault(c, 0) + 1);
    }

    for (char c : s2.toCharArray()) {
      map2.put(c, map2.getOrDefault(c, 0) + 1);
    }

    if (map1.size() != map2.size()) {
      return false;
    }

    for (char c : map1.keySet()) {
      if (!Objects.equals(map1.get(c), map2.get(c))) {
        return false;
      }
    }

    for (char c : map2.keySet()) {
      if (!Objects.equals(map2.get(c), map1.get(c))) {
        return false;
      }
    }

    int differenctPos = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        differenctPos++;
      }
    }

    return differenctPos < 3;
  }
}