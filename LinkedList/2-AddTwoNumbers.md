# 2. Add Two Numbers

Previously used a 'stupid' method (Big Integer) to solve this issue which is not correct. Got scolded. So now I implement a proper solution using carry.

Succesfully completed early morning 1am of 5th March 2024. Took me 1 hour 20 mins to figure it out. It's a small win for me today. Very tired. Going to sleep now.

## Question

Medium
Topics
Companies
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.


Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]


Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

## My proper solution - 1ms 100%

```java

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode curNode1 = l1;
        ListNode curNode2 = l2;

        ListNode res = new ListNode();
        // wrong because this was not implemented previously! See Note-A Below
        ListNode curRes = res;

        int num1=0;
        int num2=0;
        int carry=0;

        while (curNode1 !=null || curNode2 != null){
            if (curNode1 !=null){num1=curNode1.val;}
            else {num1 =0;}
            if (curNode2 !=null){num2=curNode2.val;}
            else{num2=0;}
            
            int sum = num1 +num2 + carry;
            //System.out.println("num1="+num1+" num2="+num2+ " sum="+(sum));
            if (sum>= 10){
                sum-=10;
                carry=1;
            } else{
                carry =0;
            }
            //----
            
            ListNode newNode = new ListNode(sum);
            //System.out.println("curResult="+curRes.val);
            curRes.next = newNode;
            
            //----
            if (curNode1 !=null)curNode1 = curNode1.next; 
            if (curNode2 !=null)curNode2 = curNode2.next; 
            if(curNode1 !=null || curNode2 !=null)curRes = curRes.next;
        }

        if (carry ==1){
            curRes=curRes.next;
            ListNode lastNode = new ListNode(carry);
            curRes.next=lastNode;
        }
        return res.next;
    }
}

/* Note -A
initialize curRes as ListNode curRes = res;, create a reference to the same ListNode that res is pointing to. 
This is done so that curRes can move along the result linked list as new nodes area added to it. 
Without this reference,  cannot keep track of the head of  result linked list, 
and will lose the reference to it, which is necessary for returning the full linked list.
*/

```

## My stupid solution - 53ms 5.03%

Change the linked list into two strings. Then reverse the string. Then convert the strings into BigInteger and add them together.

Then reverse the biginteger and put it back into the linked list again.

A quick fix but not the correct way to do things.

If implemented during coding challenge interviewer will raise eyebrows.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1, b = l2;
        String stra = "", strb = "";
        while (a != null) {
            int digita = a.val;
            stra += Integer.toString(digita);
            a = a.next;
        }
        while (b != null) {
            int digitb = b.val;
            strb += Integer.toString(digitb);
            b = b.next;
        }
        String corrstra = "", corrstrb = "";
        for (int i = stra.length() - 1; i >= 0; i--) {
            corrstra += stra.charAt(i);
        }
        for (int j = strb.length() - 1; j >= 0; j--) {
            corrstrb += strb.charAt(j);
        }

        BigInteger biga = new BigInteger(corrstra);
        BigInteger bigb = new BigInteger(corrstrb);
        BigInteger sum = biga.add(bigb);
        System.out.println(sum);

        String strans = sum.toString();
        ListNode head = new ListNode();
        ListNode currNode = head;
        for (int j = strans.length() - 1; j >= 0; j--) {
            int val = Integer.parseInt(String.valueOf(strans.charAt(j)));
            System.out.println("val=" + val);
            ListNode node = new ListNode(val);
            currNode.next = node;
            currNode = currNode.next;
        }
        return head.next;
    }
}

```