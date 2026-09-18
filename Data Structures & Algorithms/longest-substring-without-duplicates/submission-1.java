class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l = 0;
        int r = 0;
        Set<Character> sub = new HashSet<>();
        int result = 0;

        while(r < s.length()) {

            while(sub.contains(s.charAt(r))) {
                sub.remove(s.charAt(l));
                l++;
            }
            sub.add(s.charAt(r));
            result = Math.max(result, r-l+1);
            r++;
        }

        return result;
    }
}
