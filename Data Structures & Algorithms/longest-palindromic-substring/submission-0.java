class Solution {
    public String longestPalindrome(String s) {

        //think of considering a middle letter and expand
        //on both the sides and check for palindrome, track
        //length and the start index of the substring. In the
        //end return the substring. The catch is the way to
        //handle odd and even substrings.

        int resultLen = 0, resultIdx = 0;

        for(int i=0; i<s.length(); i++) {

            //odd substrings
            int l = i, r = i;

            while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {

                if((r - l + 1) > resultLen) {
                    resultIdx = l;
                    resultLen = r - l + 1;
                }
                l--;
                r++;
            }

            //even substrings
            l = i;
            r = i + 1;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {

                if((r - l + 1) > resultLen) {
                    resultIdx = l;
                    resultLen = r - l + 1;
                }
                l--;
                r++;
            }
        }

        return s.substring(resultIdx, resultIdx + resultLen);
        
    }
}
