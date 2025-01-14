class Solution {
  public int[] findThePrefixCommonArray(int[] A, int[] B) {
    int[] C = new int[A.length];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      map.merge(A[i], 1, Integer::sum);
      map.merge(B[i], 1, Integer::sum);
      C[i] = findPrefixCommon(map);
    }

    return C;
  }

  private int findPrefixCommon(Map<Integer, Integer> map) {
    int cnt = 0;
    for (int key : map.keySet()) {
      if (map.get(key) >= 2) {
        cnt++;
      }
    }

    return cnt;
  }

}