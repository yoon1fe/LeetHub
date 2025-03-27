class Solution {
  public int minimumIndex(List<Integer> nums) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
    }
    
    int[] dominantInfo = findDominant(map); // [0]: element, [1]: frequency
    int[] left = {0, 0};

    for (int i = 0; i < nums.size() - 1; i++) {
      if (nums.get(i) == dominantInfo[0]) {
        left[0] = nums.get(i);

        left[1]++;
        dominantInfo[1]--;
      }

      if (left[1] > ((i + 1) / 2) && dominantInfo[1] > ((nums.size() - 1 - i) / 2)) {
        return i;
      }
    }

    return -1;
  }

  private int[] findDominant(Map<Integer, Integer> map) {
    int freq = 0;
    int e = -1;
    for (int key : map.keySet()) {
      if (map.get(key) > freq) {
        freq = map.get(key);
        e = key;
      }
    }

    return new int[]{e, freq};
  }
}