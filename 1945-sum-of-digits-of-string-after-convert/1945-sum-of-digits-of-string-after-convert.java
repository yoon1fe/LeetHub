class Solution {
  public int getLucky(String s, int k) {
    int sum = 0;
    
    for (int i = 0; i < k; i++) {
      StringBuilder sb = new StringBuilder();
      sum = 0;
      // 1.
      for (char ch : s.toCharArray()) {
        if ('a' <= ch && ch <= 'z') {
          sb.append(ch - 96);
        } else {
          sb.append(ch - '0');
        }
      }

      // 2.
      for (char ch : sb.toString().toCharArray()) {
        sum += ch - '0';
      }
      s = String.valueOf(sum);
    }

    return sum;
  }
}