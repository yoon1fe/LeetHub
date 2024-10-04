class Solution {
  public long dividePlayers(int[] skill) {
    Arrays.sort(skill);
    
    int l = skill.length;
    int totalSum = skill[0] + skill[l - 1];
    long answer = 0;

    for (int i = 0; i < l / 2; i++) {
      if (skill[i] + skill[l - i - 1] != totalSum) {
        return -1;
      }

      answer += (long) skill[i] * skill[l - i - 1];
    }

    return answer;
  }
}