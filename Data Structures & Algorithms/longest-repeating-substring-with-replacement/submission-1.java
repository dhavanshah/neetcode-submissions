class Solution {
    public int characterReplacement(String s, int k) {

        Set<Character> set = new HashSet<>();

        int result = 0;

        for(char c : s.toCharArray()) {

            set.add(c);
        }

        for(char c : set) {

            int l = 0, count = 0;
            for(int r = 0; r < s.length(); r++) {

                if(s.charAt(r) == c) {
                    count++;
                }

                while((r-l+1) - count > k) {
                    if(s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }
                result = Math.max((r-l+1), result);
            }
        }
        return result;


        
    }
}
