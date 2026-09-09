class Solution {
    public boolean isValid(String s) {

        Stack<Character> braces = new Stack<>();
        Map<Character, Character> cToOpen = new HashMap<>();

        cToOpen.put(')', '(');
        cToOpen.put(']', '[');
        cToOpen.put('}', '{');

        for(char c : s.toCharArray()) {

            if(cToOpen.containsKey(c)) {

                if(!braces.isEmpty() && braces.peek() == cToOpen.get(c)) {
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
