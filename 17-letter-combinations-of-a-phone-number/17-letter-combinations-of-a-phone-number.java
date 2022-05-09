class Solution {
  private Map<Integer, List<Character>> map;
  private int[] list;
  private List<String> answer;
  public List<String> letterCombinations(String digits) {
    map = new HashMap<>();
    list = new int[digits.length()];
    answer = new LinkedList<>();
    map.put(2, Arrays.asList('a', 'b', 'c'));
    map.put(3, Arrays.asList('d', 'e', 'f'));
    map.put(4, Arrays.asList('g', 'h', 'i'));
    map.put(5, Arrays.asList('j', 'k', 'l'));
    map.put(6, Arrays.asList('m', 'n', 'o'));
    map.put(7, Arrays.asList('p', 'q', 'r', 's'));
    map.put(8, Arrays.asList('t', 'u', 'v'));
    map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    
    comb(digits, 0, 0);
    
    
    return answer;
  }
  
  private void comb(String digits, int cnt, int idx) {
    if (digits.length() == 0) {
      return;
    }
    if (digits.length() == cnt) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < list.length; i++) {
        List<Character> temp = map.get(digits.charAt(i) - '0');
        sb.append(temp.get(list[i]));
      }
      answer.add(sb.toString());
      return;
    }
    
    int digit = digits.charAt(cnt) - '0';
    
    for (int i = 0; i < map.get(digit).size(); i++) {
      list[idx] = i;
      comb(digits, cnt + 1, idx + 1);
    }
  }
}