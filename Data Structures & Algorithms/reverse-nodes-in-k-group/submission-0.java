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
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head, next;

        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;    
        }

        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode current=head, prevGroup = dummy, nextGroup = null;

        while(current!=null){
            ListNode kth=current;
            for(int i=1;i<k && kth!=null;i++){
                kth=kth.next;        
            }
            if(kth!=null){
                nextGroup = kth.next;
                kth.next=null;
                ListNode reverseHead = reverse(current);
                prevGroup.next = reverseHead;
                current.next = nextGroup;
                prevGroup = current;
                current = nextGroup;   
            }else{
                break;
            }            
        }

        return dummy.next;    
    }
}
