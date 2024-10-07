class Solution {
  public boolean areSentencesSimilar(String s1, String s2) {
    if (s1.length() == s2.length()) {
      return s1.equals(s2);
    }
    
    String[] words1 = s1.split(" ");
    String[] words2 = s2.split(" ");
    
    if (words1.length < words2.length) {
      String[] temp = words1;
      words1 = words2;
      words2 = temp;
    }

    int start = 0;
    int end = 0;
    
    while (start < words2.length && words1[start].equals(words2[start])) {
      start++;
    }

    while (end < words2.length && words1[words1.length - end - 1].equals(words2[words2.length - end - 1])) {
      end++;
    }

    return start + end >= words2.length;
  }
}