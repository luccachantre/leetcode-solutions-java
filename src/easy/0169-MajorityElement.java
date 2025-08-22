package easy;

//My Explanation: 
//the O(N) time and O(N) space (both linear with N) would be to make a hashmap to store the counts of each number
//number as key, count as value
//then if a count ever gets to at least n/2, return that number (key)

//the clever way to do it with O(1) constant space 
//is with the "Boyer-Moore Majority Voting Algorithm"
//in this implementation we initialize an int variable for a candidate (the number that currently is the majority)
//and an int count (basically by how much is that candidate in the lead in this metaphor)
//initialize candidate to nums[0] and count to 1 (saying first number is the candidate and we've seen it once)
//count track of how many times candidate has shown up so far, kinda
//so we simply iterate through the array once
//if the current number in the array equals candidate
//then we simply increment count
//else, decrement count
//AND if count hits zero, swap the candidate to the current number and increment count to 1
//so by the end of it, no matter how many different numbers come in and get and lose votes,
//the number that shows up the most times will end up being what candidate is equal to at the end of the traversal


class MajorityElement {
    

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } 
            count--;
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 2, 3, 3, 4, 4, 4, 4, 4}));
        System.out.println(majorityElement(new int[]{1, 2, 2}));
        System.out.println(majorityElement(new int[]{1, 2, 2, 3, 3, 3}));
    }
}

//DESCRIPTION
/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 

Follow-up: Could you solve the problem in linear time and in O(1) space?
 */