class Solution {
  public void reverseString(char[] s) {
    char temp = 't';
    int len = s.length;
    for (int i = 0; i < len / 2; i++) {
      swap(s, i, len - 1- i, temp);
    }
  }
  
  public void swap(char[] s, int idx1, int idx2, char temp) {
    temp = s[idx1];
    s[idx1] = s[idx2];
    s[idx2] = temp;
  }
}