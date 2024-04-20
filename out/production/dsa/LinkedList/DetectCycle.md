# Detect Whether A Link List Contains A Cycle

Medium in HackerRank , Easy in LeetCode - But a good question.

Implement tortoise and hare solution.

https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem?isFullScreen=true


## My Code

Use try catch block to handle null pointer exception.

If its null, then definitely no cycle, return false.

```java
static boolean hasCycle(SinglyLinkedListNode head) {
        
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.next.next;
        
        while (true){
            if (fast == null || slow == null)return false;
            else if (slow.equals(fast)){
                System.out.println(String.format("slow=%s , fast=%s",slow.data,fast.data));
                break;
            }
            try{
                slow= slow.next;
                fast =fast.next.next;
            }catch(Exception e){
                System.out.println("Exception="+e);
                return false;
            }
            
            
        }

        return true;
    }

```