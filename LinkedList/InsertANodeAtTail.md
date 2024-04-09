# Insert A Node At The Tail Of A Linked List

A simple question that gave me alot of problems.

1. Instruction was not written clearly. The function is called multiple times and the head can be null. That explains why although data is a single integer , there is a whole stream of datas.

2. Unfortunately my linked list basics is still not good. Had trouble when traversing to the end of the linked list. My initial attempt travelled until after the tail which is then null. Need to polish up basics.

https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem?isFullScreen=true

## The question

You are given the pointer to the head node of a linked list and an integer to add to the list. Create a new node with the given integer. Insert this node at the tail of the linked list and return the head node of the linked list formed after inserting this new node. The given head pointer may be null, meaning that the initial list is empty.

Function Description

Complete the insertNodeAtTail function in the editor below.

insertNodeAtTail has the following parameters:

SinglyLinkedListNode pointer head: a reference to the head of a list
int data: the data value for the node to insert
Returns

SinglyLinkedListNode pointer: reference to the head of the modified linked list
Input Format

The first line contains an integer , the number of elements in the linked list.
The next  lines contain an integer each, the value that needs to be inserted at tail.

Constraints

Sample Input

STDIN Function ----- -------- 5 size of linked list n = 5 141 linked list data values 141..474 302 164 530 474

Sample Output

141
302
164
530
474
Explanation

First the linked list is NULL. After inserting 141, the list is 141 -> NULL.
After inserting 302, the list is 141 -> 302 -> NULL.
After inserting 164, the list is 141 -> 302 -> 164 -> NULL.
After inserting 530, the list is 141 -> 302 -> 164 -> 530 -> NULL. After inserting 474, the list is 141 -> 302 -> 164 -> 530 -> 474 -> NULL, which is the final list.

## My code after understanding why my initial solution doesnt work

```java
static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        
        if (head==null){
            head = new SinglyLinkedListNode(data);
        }else {
            SinglyLinkedListNode curNode = head;
            while(curNode!=null){
                if (curNode.next == null)break;// --> break before we reach a null!
                curNode=curNode.next;
            }
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            curNode.next=newNode;
        }
        
        return head;
    }
```


## My code after referencing Elnaz

```java

static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        
        if (head==null){
            head = new SinglyLinkedListNode(data);
        }else {
            SinglyLinkedListNode curNode = head;
            while(curNode.next!=null){
                curNode=curNode.next;
            }
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            curNode.next=newNode;
        }
        
        return head;
    }
```