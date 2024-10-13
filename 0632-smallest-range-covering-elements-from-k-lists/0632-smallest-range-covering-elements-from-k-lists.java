class Solution {
  public int[] smallestRange(List<List<Integer>> nums) {
    int[] pointers = new int[nums.size()];
    int[] answer = {0, Integer.MAX_VALUE};
    int[] numArray = new int[nums.size()];

    
    while (true) {
      int min = Integer.MAX_VALUE;
      int max = min * -1;
      int minIdx = 0;

      for (int i = 0; i < nums.size(); i++) {
        int n = nums.get(i).get(pointers[i]);
        numArray[i] = n;
        
        if (min > n) {
          min = n;
          minIdx = i;
        }
        min = Math.min(min, n);
        max = Math.max(max, n);
      }

      if (answer[1] - answer[0] > max - min) {
        answer[1] = max;
        answer[0] = min;
      }

      pointers[minIdx]++;
      if (pointers[minIdx] >= nums.get(minIdx).size()) break;
    }

    return answer;
  }
}