package src.easy;

import java.util.HashMap;
import java.util.Stack;

//My Explanation:
//so there are two ways to do this, with HashMap and Stack, or with just Stack.
//with HashMap is generally better because it is easier to modify if more paretheses pairs need to be added later
//stack only solution is of course less memory but is pretty verbose

//but with or without a map, the core logic is the same:
//iterate through each character of the string
//if it is an opener, add it's corresponding closer to the stack
//if it is a closer,
//if either the stack is empty (which it shouldnt be if we're currently on a closer)
//or stack.pop() != the character/closer we're currently on
//return false
//then outside the for each loop, return stack.isEmpty();
//this works because the stack.pop() call in the if statement will actually run that method and will actually pop from the stack
//so we don't need to explicitly call it in its own line
//if we wanted to we could do like if stack.peek() != currentCloser or whatever
//then return false
//else stack.pop() I think

class ValidParentheses {

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]{}"));
        System.out.println(isValid("([{}])"));
    }
}

//DESCRIPTION
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Example 5:
Input: s = "([)]"
Output: false

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/