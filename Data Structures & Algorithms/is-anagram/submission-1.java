class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> visitedS = new HashMap<>();
        Map<Character, Integer> visitedT = new HashMap<>();

        if(s.length() != t.length()) {
            return false;
        }

        for(int i=0; i < s.length(); i++) {
            visitedS.put(s.charAt(i), visitedS.getOrDefault(s.charAt(i),0) + 1);
            visitedT.put(t.charAt(i), visitedT.getOrDefault(t.charAt(i),0) + 1);

        }

        return visitedS.equals(visitedT);

    }
}
