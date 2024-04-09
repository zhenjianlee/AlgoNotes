# Reverse Linked List

Easy question - a classic question, good for recap

https://www.hackerrank.com/challenges/reverse-a-linked-list/problem?isFullScreen=true

## My Code

```java
public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
    // Write your code here
        if(llist==null){
            return new SinglyLinkedListNode(0);
        }
        
        SinglyLinkedListNode prevNode=null;
        SinglyLinkedListNode curNode=llist;
        
        while (curNode !=null){
            SinglyLinkedListNode temp = curNode.next;;
            curNode.next=prevNode;
            prevNode=curNode;
            curNode=temp;
            
        }
        return prevNode;
    }
```