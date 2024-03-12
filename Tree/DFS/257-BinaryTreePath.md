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

## Second Attempt - Does not work!

I attempted to place the String to become an instance variable. This no longer works.

Input
root =
[1,2,3,null,5]
Output
["1->2->5","3"]
Expected
["1->2->5","1->3"]

Reason :-
The issue you're encountering stems from the fact that path is being treated as an instance variable and shared across all recursive calls. When you modify path in one branch of recursion, it affects the path variable for all other branches. To fix this issue, you need to ensure that each branch of recursion operates on its own separate path variable. Each recursive call has its own separate path variable, eliminating the issue of shared state causing incorrect results.


```java
class Solution {

    private String path;

    public List<String> binaryTreePaths(TreeNode root) {
        path = "";
        ArrayList<String> res = new ArrayList<>();
        preOrderTraverse(res,root);
        return res;
        
    }

    private void preOrderTraverse(ArrayList<String> list,TreeNode node){

        if (node == null)return;

        path += Integer.toString(node.val)+"->";
        if (node.left == null && node.right == null){
            String submitpath=path.substring(0,path.length()-2);
            list.add(submitpath);
            path="";
        }

        preOrderTraverse(list,node.left);
        preOrderTraverse(list,node.right);

        return;


    }
}



```

Since each recursion String path needs to have its own unique path, it makes sense not to use an instance variable for path.

So I refactored the code to take in the ArrayList as an instance variable instead.

It now works because all recursive calls still use the same ArrayList.

8ms - 40.57%

```java
class Solution {

    private ArrayList<String>res;

    public List<String> binaryTreePaths(TreeNode root) {
        String path = "";
        res = new ArrayList<>();
        preOrderTraverse(path,root);
        return res;
        
    }

    private void preOrderTraverse(String path,TreeNode node){

        if (node == null)return;

        path += Integer.toString(node.val)+"->";
        if (node.left == null && node.right == null){
            String submitpath=path.substring(0,path.length()-2);
            res.add(submitpath);
            path="";
        }

        preOrderTraverse(path,node.left);
        preOrderTraverse(path,node.right);

        return;
    }
}

```