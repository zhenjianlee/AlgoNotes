## Lowest Common Ancestor

Easy - but very tricky , could not solve without referencing.

https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem?isFullScreen=true

The point is to keep track of curNode.val and see if its either bigger or smaller THAN BOTH VALUE 1 AND VALUE 2.

If smaller, move right.

If bigger, move left.

The moment the condition no longer meets above, it means the current node has entered between the 'min' and the 'max'. So that is the LCA!

## The Question

You are given pointer to the root of the binary search tree and two values  and . You need to return the lowest common ancestor (LCA) of  and  in the binary search tree.

https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem?isFullScreen=true


## Solving Iteratively

```java

public static Node lca(Node root, int v1, int v2) {
      	// Write your code here.
          
          Node curNode = root;
          
          while(curNode!= null){
              int dat = curNode.data;
              
              if (dat > v1 && dat > v2){
                  curNode=curNode.left;
              }
              else if (dat <v1 && dat <v2){
                  curNode=curNode.right;
              }else{
                  break;
              }
          }
        return curNode;
    }
```

## Solving recursively

```java

public static Node lca(Node root, int v1, int v2) {
      	// Write your code here.
          if (root == null)return null; //---> dont really need this 
          
          if(root.data < v1 && root.data < v2){
             root= lca(root.right,v1,v2);
          }else if (root.data > v1 && root.data > v2){
              root=lca(root.left,v1,v2);
          }
          
          return root;
    }
```



