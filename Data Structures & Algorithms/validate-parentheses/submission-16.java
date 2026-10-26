class Solution {
    public boolean isValid(String s) {

        Map<Character, Character> lookup = new HashMap<>();

        lookup.put('}' , '{');
        lookup.put(']' , '[');
        lookup.put(')' , '(');

        Stack<Character> braces = new Stack<>();

        for(char c : s.toCharArray()) {//O(n)

            //checks if the char is an closing brace
            if(lookup.containsKey(c)) { //O(1)

                if(!braces.isEmpty() && braces.peek().equals(lookup.get(c))) {
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
