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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)
            return;

        ListNode slow=head, fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode second = slow.next;
        slow.next=null;

        ListNode prev=null, curr=second, next;

        while(curr.next!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        curr.next=prev;

        ListNode reversedSecond = curr;

        boolean flag=true;

        ListNode answer = new ListNode(), temp=answer;

        while(head!=null || reversedSecond!=null){
            if(flag){
                temp.next=head;
                head = head.next;
                flag=false;
            }else{
                temp.next=reversedSecond;
                reversedSecond=reversedSecond.next;
                flag=true;
            }
            temp=temp.next;
        }
        head=answer.next;
        return;

    }
}
