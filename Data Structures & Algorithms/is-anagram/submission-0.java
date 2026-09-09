class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> visitedS = new HashMap<>();
        Map<Character, Integer> visitedT = new HashMap<>();

        for(int i=0; i < s.length(); i++) {

            if(visitedS.containsKey(s.charAt(i))) {
                visitedS.put(s.charAt(i), visitedS.getOrDefault(s.charAt(i),0) + 1);
            }
            visitedS.put(s.charAt(i), visitedS.getOrDefault(s.charAt(i),0) +1);

        }

        for(int j=0; j<t.length(); j++) {

            if(visitedT.containsKey(t.charAt(j))) {
                visitedT.put(t.charAt(j), visitedT.get(t.charAt(j)) + 1);
            }
            visitedT.put(t.charAt(j), visitedT.getOrDefault(t.charAt(j),0) +1);

        }

        if(visitedS.equals(visitedT)) {
            return true;
        } else {
            return false;
        }

    }
}
