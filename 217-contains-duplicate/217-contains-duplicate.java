class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean answer = false;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        
        for (int key : map.keySet()) {
            answer = answer | map.get(key) != 1;
        }
        
        return answer;
    }
}