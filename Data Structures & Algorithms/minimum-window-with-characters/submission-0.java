class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();

        for(char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = tCount.size();
        int l = 0; int minLength = Integer.MAX_VALUE;
        int[] result = {-1,-1};

        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
            
            if(tCount.containsKey(c) && sCount.get(c).equals(tCount.get(c))) {
                have++;
            }

            while(have == need) {
                if((r-l+1) < minLength) {
                    minLength = r - l + 1;
                    result[0] = l;
                    result[1] = r;
                }

                char left = s.charAt(l);

                sCount.put(left, sCount.get(left) - 1);
                if(tCount.containsKey(left) && sCount.get(left) < tCount.get(left)) {
                    have--;
                }
                l++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
        
    }
}
