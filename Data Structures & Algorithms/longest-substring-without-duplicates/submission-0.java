class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> lookUp = new HashSet<>();

        int l = 0;
        int r = 0;

        int len = 0;

        while(r < s.length()) {

            while(lookUp.contains(s.charAt(r))) {
                lookUp.remove(s.charAt(l));
                l++;
            }
            lookUp.add(s.charAt(r));
            len = Math.max(len, r-l+1);
            r++;
        }
        
        return len;
    }
}
