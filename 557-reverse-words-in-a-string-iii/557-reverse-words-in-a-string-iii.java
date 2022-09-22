class Solution {
  public String reverseWords(String s) {
    StringBuilder answer = new StringBuilder();
    String[] split = s.split(" ");
    int idx = 0;
    
    for (String str : split) {
      idx++;
      StringBuilder temp = new StringBuilder(str);
      answer.append(temp.reverse());
      
      if (idx < split.length) answer.append(" ");
    }
    
    return answer.toString();
  }
}