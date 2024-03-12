# 257 Binary Tree Path

Easy question good for refreshing pre order traversal concept

## The question

Easy
Topics
Companies

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:

Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Example 2:

Input: root = [1]
Output: ["1"]

 

Constraints:

    The number of nodes in the tree is in the range [1, 100].
    -100 <= Node.val <= 100


## My code - 8ms 41.4%

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
    public List<String> binaryTreePaths(TreeNode root) {

        ArrayList<String> res = new ArrayList<>();
        String path = "";
        preOrderTraverse(res,path,root);
        return res;
        
    }

    private void preOrderTraverse(ArrayList<String> list,String path, TreeNode node){

        if (node == null)return;

        path += Integer.toString(node.val)+"->";
        if (node.left == null && node.right == null){
            String submitpath=path.substring(0,path.length()-2);
            list.add(submitpath);
            path="";
        }

        preOrderTraverse(list,path,node.left);
        preOrderTraverse(list,path,node.right);

        return;


    }
}


```