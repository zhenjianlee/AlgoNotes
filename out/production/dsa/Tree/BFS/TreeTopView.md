# Tree Top View


"Easy" - its not easy, but they said its easy. Ok loh. https://www.hackerrank.com/challenges/tree-top-view/problem?isFullScreen=true

But it is really very interesting.

To solve this we need to create a static class ( a class within a class).

Then we use this class to keep track of its current horizontal distance and the node itself.

Read below.

## The Question

Given a pointer to the root of a binary tree, print the top view of the binary tree.

The tree as seen from the top the nodes, is called the top view of the tree.
```
For example :

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4

```
Top View : 

Complete the function  and print the resulting values on a single line separated by space.

Input Format

You are given a function,

void topView(node * root) {

}
Constraints

 Nodes in the tree  

Output Format

Print the values on a single line separated by space.

```
Sample Input

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
```

Sample Output

1 2 5 6

Explanation
```
   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
```
From the top, only nodes  are visible.

## My Code - Referenced from GTG

https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/

```java
class Solution {

	/* 
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    
    static class QObject{
        
        Node node;
        int hd;
        
        public QObject(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
        
    }
    
    
	public static void topView(Node root) {
        
        Queue<QObject> q = new LinkedList<>();
        Map<Integer,Integer> hmap = new HashMap<>();
        q.offer(new QObject(root,0));
        
        int min=0;
        int max=0;
        
        while (!q.isEmpty()){
            QObject curQObject = q.poll();
            int curHD = curQObject.hd;
            Node curNode = curQObject.node;
            int curData = curNode.data;
            
            // THIS IS WRONG! THIS WILL PUT EVERYTHING INSIDE WHICH WE DONT WANT
            // hmap.putIfAbsent(curHD, 0);
            // hmap.put(curHD,curData);
            
            // THIS IS CORRECT! THIS WILL PUT ONLY THE FIRST INSTANCE OF CURHD!
            if (!hmap.containsKey(curHD)){
                hmap.put(curHD,curData);
            }
            
            if (curNode.left != null){
                min= Math.min(min,curHD-1);
                q.offer(new QObject(curNode.left,curHD-1));
            }
            
            if (curNode.right !=null){
                max = Math.max(max, curHD+1);
                q.offer(new QObject(curNode.right,curHD+1));
            }
            
        }
        
        for (int i=min ; i<=max ; i++){
            System.out.print(hmap.get(i)+ " ");
        }
      
      
    }



```