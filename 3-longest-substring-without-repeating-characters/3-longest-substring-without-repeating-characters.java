class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int answer = 0;

        while (r < s.length()) {
            if (l > r) break;

            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r++));
                answer = Math.max(answer, r - l);
            } else {
                set.remove(s.charAt(l++));
            }
        }

        return answer;
    }
}