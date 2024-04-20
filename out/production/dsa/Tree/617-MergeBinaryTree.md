# 617 - Merge Binary Tree

Overwrite the left binary tree to merge it together. Can use both DFS and BFS to solve this problem.

## Question

Easy
Topics
Companies
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.

 

Example 1:


Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]
Example 2:

Input: root1 = [1], root2 = [1,2]
Output: [2,2]
 

Constraints:

The number of nodes in both trees is in the range [0, 2000].
-104 <= Node.val <= 104


## DFS - Referenced solution

Couldn't solve this problem. Had to reference from solution.

```java
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 ==null)return root2;

        if (root2==null)return root1;

        root1.val +=root2.val;

        root1.left =mergeTrees(root1.left,root2.left);
        root1.right =mergeTrees(root1.right,root2.right);

        return root1;
        
    }
}

```

## BFS - Referenced solution

Initially tried to implement this but could not solve. 

``` java
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null)
            return root2;

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] { root1, root2 });

        while (!stack.isEmpty()) {

            TreeNode[] array = stack.pop();
            // refer Note A
            if (array[0] == null || array[1] == null)
                continue;


            array[0].val += array[1].val;
            if (array[0].left == null) {
                array[0].left = array[1].left;
            } else {
                stack.push(new TreeNode[] { array[0].left, array[1].left });
            }

            if (array[0].right == null) {
                array[0].right = array[1].right;
            } else {
                stack.push(new TreeNode[] { array[0].right, array[1].right });
            }
        }
        return root1;
    }

    /*
     * Note A
     * 
     * If t[0] is null, it means there's no corresponding node in the first tree at
     * the current position. In this case, we simply take the node from the second
     * tree and continue with the merging process.
     * 
     * If t[1] is null, it means there's no corresponding node in the second tree at
     * the current position. In this case, there's nothing to merge from the second
     * tree, so we just continue with the merging process using the node from the
     * first tree.
     * 
     * By skipping the process when either node is null, we ensure that we only
     * merge nodes where both trees have a corresponding node. This prevents us from
     * attempting to access properties or perform operations on null references,
     * ensuring that the algorithm processes all relevant nodes correctly and
     * produces the merged tree as expected.
     * 
     * 
     */
}

```

