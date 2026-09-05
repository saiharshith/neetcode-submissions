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

        ListNode result = new ListNode(0);

        int sum, carry=0;

        ListNode temp1=l1, temp2=l2, temp3 = result;

        while(temp1!=null || temp2!=null){
            sum=0;
            if(temp1==null){
                sum=temp2.val+carry;
                temp2=temp2.next;
            }else if(temp2==null){
                sum=temp1.val+carry;
                temp1=temp1.next;
            }else{
                sum=temp1.val+temp2.val+carry;
                temp1=temp1.next;
                temp2=temp2.next;
            }
            carry=sum/10;
            sum=sum%10;

            temp3.next = new ListNode(sum);
            temp3=temp3.next;
        }

        if(carry!=0){
            temp3.next=new ListNode(carry);
        }

        return result.next;
        
    }
}
