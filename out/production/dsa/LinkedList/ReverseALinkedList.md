# Reverse Linked List

Easy question - a classic question, good for recap

Singly:

https://www.hackerrank.com/challenges/reverse-a-linked-list/problem?isFullScreen=true

Doubly:

https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem?isFullScreen=true


## My Code - Singly

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

## My Code - Doubly

Had to refer to others. I added in one more step which caused cycle.

Rule of thumb - only manipulate the .next and .prev of curNode

```java
public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
    // Write your code here
        DoublyLinkedListNode prevNode = null;
        DoublyLinkedListNode curNode =llist;
        
        if (curNode == null)return null;
        while (curNode != null){
           DoublyLinkedListNode temp = curNode.next; //1 save temp
           curNode.next =prevNode; //2 rev curNode
           /*
           DONT NEED THIS PART! WILL CAUSE CYCLE!
           if (prevNode !=null){
               prevNode.next=curNode; 
               //prevNode.prev =curNode.next.next;
           }
           */
           curNode.prev =temp; // 3 ---> this is the only diff between singly and doubly
           prevNode=curNode; // reassign prevNode
           curNode = temp; // reassing curNode

        }
        return prevNode;

    }


```