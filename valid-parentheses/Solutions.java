// Valid Parentheses
// Leetcode Problem 20
// https://leetcode.com/problems/valid-parentheses/
//Same approach presented in the 10/22 meeting, deals with the issue of matching the opposite facing characters with a HashMap

class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1)
            return false;
        
        Stack<Character> st = new Stack<>();
        HashMap<Character,Character> pairs = new HashMap<>();
        pairs.put('}','{');
        pairs.put(')','(');
        pairs.put(']','[');
        
        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                case '{':
                case '[':
                case '(':
                    st.push(s.charAt(i));
                    break;
                case '}':
                case ']':
                case ')':
                    if(!st.isEmpty() && pairs.get(s.charAt(i)) == st.peek())
                        st.pop();
                    else
                        return false;
                    break;
            }
        }
        return st.isEmpty();
    }
}
