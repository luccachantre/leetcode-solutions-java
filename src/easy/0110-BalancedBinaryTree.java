package easy;

//My Explanation: 
//the suboptimal solution (O(N^2) I believe)
//starting from the root, we will go top down checking if each tree is balanced
//then recursively call isbalanced on the root's left and right child
//the base case is: if (root == null) return true;
//if that's not the case, we call a helper function getTreeHeight(TreeNode node) the node's left and right child
//this function also is recursive, also has a base case if (root == null) return 0; (a little different)
//and it returns 1 + Math.max(getTreeHeight(node.left),getTreeHeight(node.right))
//so say we go through all the recursive calls of getTreeHeight and we're back in isBalanced, 
//we assigned the heights of left and right subtrees to variables 'left' and 'right'
//now we return true if the absolute value of left - right is less than or equal to 1 (or just less than 2)
//AND if isBalanced(root.left) && isBalanced(root.right)
//we do those last two checks because remember we need to check if every subtree is balanced
//but this is the suboptimal way for a reason I don't currently understand, 
//I will return later/on another day and update this to be the optimal solution
//which has a bottom up implementation (start by checking if the smallest subtrees are balanced first and go up)


class BalancedBinaryTree {
    public class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        int left = getTreeHeight(root.left);
        int right = getTreeHeight(root.right);

        return Math.abs(left - right) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getTreeHeight(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
    }

    public static void main(String[] args) {
        System.out.print("not sure how to test for nodes and stuff yet/at the moment, but this code works just trust");
    }
}

//DESCRIPTION
/*
Given a binary tree, determine if it is height-balanced.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
 */