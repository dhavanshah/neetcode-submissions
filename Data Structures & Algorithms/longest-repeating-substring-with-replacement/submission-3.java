class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> freqMap = new HashMap<>();

        int l=0;
        int result=0;

        for(int r=0; r<s.length(); r++) {

            freqMap.put(s.charAt(r), freqMap.getOrDefault(s.charAt(r), 0) + 1);

            while((r - l + 1) - Collections.max(freqMap.values()) > k) {
                
                freqMap.put(s.charAt(l), freqMap.get(s.charAt(l)) - 1);
                l++;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
        
    }
}