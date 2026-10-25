class Solution {
    public boolean isValid(String s) {

        Map<Character, Character> braces = new HashMap<>();

        Stack<Character> lookup = new Stack<>();

        braces.put('}','{');
        braces.put(')','(');
        braces.put(']','[');

        for(char c : s.toCharArray()) {

            if(c == '}' || c == ')' || c == ']') {
                if(!lookup.isEmpty() && lookup.peek() == braces.get(c)) {
                    lookup.pop();
                } else {
                    return false;
                }
            } else {
                lookup.push(c);
            }
        }

        return lookup.isEmpty();
        
    }
}
