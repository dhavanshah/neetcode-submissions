class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) {
            return false;
        }

        int[] freq = new int[26];

        for(char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int l=0;
        int n = s1.length();
        int r = l + (n-1);

        while(r < s2.length()) {

            int[] winFreq = new int[26];

            for(char c : s2.substring(l, r+1).toCharArray()) {
                winFreq[c - 'a']++;
            }
            
            if(Arrays.equals(freq, winFreq)) {
                return true;
            }
            l++;
            r++;
        }
        return false;
    }
}
