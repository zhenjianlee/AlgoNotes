# 111-Minimum Depth Binary Tree

This solution can be done either by DFS or BFS.

Was not able to solve. Need to revise.

## Question

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 

Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000


## Referenced DFS Solution - 6ms 27.84%

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
    public int minDepth(TreeNode root) {

        if (root == null)return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (left==0 || right ==0)? left+right+1: Math.min(left,right)+1;
        
    }

}


```

## Referenced BFS Solution 1ms 99.93%

```java
class Solution {
    public int minDepth(TreeNode root) {

        if(root==null)return 0;
        int height = 1;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

                // removing the head of the queue must be within the for loop!
                TreeNode curNode = q.poll();
                if (curNode.left == null && curNode.right == null)
                    return height;
                if (curNode.left != null)
                    q.offer(curNode.left);
                if (curNode.right != null)
                    q.offer(curNode.right);
            }
            height++;
        }
        return height;
    }
}
/*

Queue -offer (add to !end! of list) , poll (remove from beginning).
Stack - push (add to the !start! of list) , pop (remove from the top )

*/

```