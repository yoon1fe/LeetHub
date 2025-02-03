class Solution {
  public int longestMonotonicSubarray(int[] nums) {
    int answer = 1;
    boolean increasing = true;
    
    for (int i = 0; i < nums.length - 1; i++) {
      System.out.println("i = " + i  + ", answer = " + answer);
      int cur = nums[i];
      int adj = nums[i + 1];
      int count = 2;
      if (cur < adj) {
        increasing = true;
      } else if (cur > adj) {
        increasing = false;
      } else {
        continue;
      }
      for (int j = i + 2; j < nums.length; j++) {
        int next = nums[j];
        if (adj == next) {
          break;
        }
        if (increasing) {
          if (adj< next) {
            count++;
          } else {
            break;
          }
        } else {
          if (adj > next) {
            count++;
          } else {
            break;
          }
        }
        
        adj = next;
      }

      answer = Math.max(answer, count);
    }

    return answer;
  }
}