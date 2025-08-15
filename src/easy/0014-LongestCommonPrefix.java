package easy;

//My Explanation: 
//honestly I don't fully understand this solution still
//but the idea is to set the first string in strs to be what we check everything else against
//called "prefix" 
//and then we iterate through every other string in strs, and for each one we do a strangle while loop
//while strs[i].indexOf(prefix) != 0
//I had no clue what this meant when i first saw it but I kinda get it now
//its saying: if strs[i] contains prefix, then do nothing, keep prefix as it is
//example, strs = ["ball", "baller"] prefix is ball and strs[i] is baller
//strs[i].indexOf(prefix) would equal zero in the first check of the while loop so we do nothing
//if it was the other way around, baller is prefix and ball is strs[i]
//then the while loop check does not equal zero, 
//so we take one character off the end of prefix (baller) and check again, 
//now baller is balle, but ball still does not contain balle, index of will still not equal zero
//so we remove a character again, and then prefix is ball and it passes the check, and we're done
//prefix is ball and we return it. 
//and this will work for all cases, sorry this is the best explanation i can give for my current understanding
class LongestCommonPrefix {
    

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ball", "baller"}));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "floor"}));
        System.out.println(longestCommonPrefix(new String[]{"track", "there", "tallest"}));
    }
}

//DESCRIPTION
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".


Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
 */