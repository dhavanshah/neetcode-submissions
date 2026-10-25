class Solution {
    public boolean isValid(String s) {

        Map<Character, Character> lookup = new HashMap<>();

        Stack<Character> braces = new Stack<>();

        lookup.put('}','{');
        lookup.put(')','(');
        lookup.put(']','[');

        for(char c : s.toCharArray()) {

            if(lookup.containsKey(c)) {
                if(!braces.isEmpty() && braces.peek() == lookup.get(c)) {
                    braces.pop();
                } else {
                    return false;
                }
            } else {
                braces.push(c);
            }
        }

        return braces.isEmpty();
        
    }
}
