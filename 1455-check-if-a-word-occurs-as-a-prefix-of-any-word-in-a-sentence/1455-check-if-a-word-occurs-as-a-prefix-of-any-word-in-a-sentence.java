class Solution {
  public int isPrefixOfWord(String sentence, String searchWord) {
    int answer = -1;
    String[] split = sentence.split(" ");
    for (int i = 0; i < split.length; i++) {
        if (split[i].startsWith(searchWord)) {
            answer = i + 1;
            break;
        }
    }
    return answer;
  }
}