class Solution {
  public int maximumSwap(int num) {
    String str = String.valueOf(num);
    int[] last = new int[10];
    
    for (int i = 0; i < str.length(); i++) {
      last[str.charAt(i) - '0'] = i;
    }

    for (int i = 0; i < str.length(); i++) {
      for (int j = 9; j > str.charAt(i) - '0'; j--) {
        if (last[j] > i) {
          return swap(str, last[j], i);
        }
      }
    }
    
    return num;
  }

  private int swap(String num, int i, int j) {
    char[] charArray = num.toCharArray();

    char temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
    
    return Integer.parseInt(new String(charArray));
  }
}