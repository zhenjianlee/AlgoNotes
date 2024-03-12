# 404 - Sum of Left Leaves

A simple BFS question to refresh memory on doing a level order traversal. Basis for more complicated questions to come.

1. Use a LinkedList or Stack

2. Push root into LL/S

3. While LL/S is not empty, keep removing Nodes. Process the left or right nodes and put into LL/S.

4. Business logic

5. Repeat until all nodes have been traversed.

## Question

Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
Example 2:

Input: root = [1]
Output: 0
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000

## My Code - 0ms 100%

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
    public int sumOfLeftLeaves(TreeNode root) {

        //can also use stack, push and pop, empty() , same principle
        LinkedList<TreeNode> list = new LinkedList<>();
        list.push(root);
        int sum=0;
        while (list.size()>0){
            TreeNode curNode = list.pop();
            TreeNode left = curNode.left;
            TreeNode right=curNode.right;

            if (left != null){
                list.push(left);

                //specific to this question----
                if (left.left == null && left.right == null){
                    sum+=left.val;
                }
                //specific to this question----
            }

            if (right !=null){
                list.push(right);
            }

        }
        return sum;
    }
}

```