class Solution {
    public int characterReplacement(String s, int k) {

        int result = 0;
        int freq = 0;
        int l = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for(int r=0; r<s.length(); r++) {

            freqMap.put(s.charAt(r), freqMap
            .getOrDefault(s.charAt(r), 0) + 1);

            freq = Math.max(freq, freqMap.get(s.charAt(r)));

            while((r-l+1)-freq > k) {
                freqMap.put(s.charAt(l), freqMap.get(s.charAt(l)) - 1);
                l++;
            }
            result = Math.max(result, (r-l+1));
        }
        
        return result;
    }
}