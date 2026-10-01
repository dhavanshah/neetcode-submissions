class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }
        
        int l = 0;

        for(int r=0; r<s2.length(); r++) {

            freq2[s2.charAt(r) - 'a']++;

            if((r - l + 1) > s1.length()){
                freq2[s2.charAt(l) - 'a']--;
                l++;
            }

            if((r - l + 1) == s1.length()) {
                boolean match = true;
                //int match = 0;
                for(int i=0; i<26; i++) {
                    if(freq1[i] != freq2[i]) {
                        match = false;
                        //match++;
                        //break;
                    }
                }
                if(match) {
                    return true;
                }
            }
        }
        return false;
    }
}
