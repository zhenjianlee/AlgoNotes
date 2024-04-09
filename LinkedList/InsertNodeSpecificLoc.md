# Insert A Node At A Specific Position In A Linked List

Simple question - good for recap

https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem?isFullScreen=true

## My Code

```java

public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
    // Write your code here
        if (llist==null){
            llist = new SinglyLinkedListNode(data);
        }else{
            SinglyLinkedListNode curNode = llist;
            int curPos=0;
            while(curNode!= null){     
                if (curPos == position-1){
                    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
                    SinglyLinkedListNode nextNode = curNode.next;
                    curNode.next=newNode;
                    newNode.next=nextNode;
                    break;
                }
                curNode= curNode.next;
                curPos++;
                
            }
            
        }
        return llist;

    }


```