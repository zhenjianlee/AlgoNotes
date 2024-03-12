# 110-BalancedBinaryTree

Although this is a simple question, it is quite difficult.

The reason for Note A line is to ensure that the left and right subtree itself is balanced before comparing to each other.

The reson for Note B is to add 1 each time a recursion call is activated to check the depth.

Need to revise.

## Question

Given a binary tree, determine if it is 
height-balanced
.

 

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


## My code

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left =0;
        int right=0;
        if (root !=null){
            left=dfs(root.left);
        }

        if (root !=null){
            right=dfs(root.right);
        }
        System.out.println("left="+left+" right="+right);

        //cannot figure out why need to include isBalanced for root.left and root.right
        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode node){
        if (node == null)return 0;

        //cannot figure out +1 - see NoteB
       return Math.max(dfs(node.left),dfs(node.right))+1;
    }

}

/*
Note A - 
-------

The line return Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right); is an additional check to ensure that not only the difference in heights between the left and right subtrees is less than or equal to 1 (Math.abs(left-right) <= 1), but also that both the left and right subtrees themselves are balanced.

Here's why both checks are necessary:

Math.abs(left-right) <= 1: This condition ensures that the difference in heights between the left and right subtrees of the current node is at most 1, which is a property of balanced binary trees.

isBalanced(root.left) && isBalanced(root.right): This recursively checks whether both the left and right subtrees are also balanced. Even if the height difference between the left and right subtrees of the current node is within the acceptable range, if either the left or right subtree is not balanced itself, the entire tree rooted at the current node cannot be considered balanced.

So, both conditions are necessary for ensuring that the tree is balanced:

The first condition (Math.abs(left-right) <= 1) checks the balance condition at the current node.
The second condition (isBalanced(root.left) && isBalanced(root.right)) recursively checks the balance condition for both left and right subtrees.



Note B
------
In the code you provided, the function dfs(TreeNode node) is a depth-first search (DFS) function that calculates the height of the subtree rooted at the given node. The line return Math.max(dfs(node.left), dfs(node.right)) + 1; calculates the height of the current node by taking the maximum height between its left and right subtrees and adding 1 to it.

The reason we add 1 is because we're considering the current node itself in the height calculation. Each node contributes a height of 1 to the total height of its subtree. So, when we take the maximum height between the left and right subtrees and add 1, we're essentially adding the height of the current node to the maximum height of its subtrees.

This calculation ensures that we're correctly computing the height of the subtree rooted at the current node, which is essential for determining whether the tree is balanced or not.

*/

```