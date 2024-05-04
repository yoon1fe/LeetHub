class Solution {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int boats = 0;
    int left = 0, right = people.length - 1;
    // 1, 2, 4, 5, 6
    // 1, 2, 2, 3 / 3

    while (left <= right) {
      if (people[left] + people[right] <= limit) {
        left++;
      }

      right--;
      boats++;
    }

    return boats;
  }
}