class Solution {
  public int uniqueMorseRepresentations(String[] words) {
    String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    Set<String> set = new HashSet<>();
    
    for (String word : words) {
      set.add(makeMorse(word, morse));
    }

    return set.size();
  }
  
  public String makeMorse(String word, String[] morse) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      sb.append(morse[ch - 97]);
    }
    
    return sb.toString();
  }
}