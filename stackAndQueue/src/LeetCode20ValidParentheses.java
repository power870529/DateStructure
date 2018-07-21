import java.util.LinkedList;

/**Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
*/

public class LeetCode20ValidParentheses {

    public static boolean isValid(String s) {

        LinkedList<Character> stack = new LinkedList<>();

        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if(c == '(' && topChar != ')') {
                    return false;
                }
                if(c == '[' && topChar != ']') {
                    return false;
                }
                if(c == '{' && topChar != '}') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = ")([]{}()";
        System.out.println(LeetCode20ValidParentheses.isValid(s));
    }
}
