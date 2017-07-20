/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int len1 = getLength(l1);
        int len2 = getLength(l2);
        int lenL = Math.max(len1, len2);
        int lenS = Math.min(len1, len2);
        
        ListNode longList = len1 >= len2 ? l1 : l2;
        ListNode shortList = len1 >= len2 ? l2 : l1;

        int[] buf = new int[lenL+1];

        for(int i = 0; i < lenL; i++){
            if(i+lenS < lenL){
                buf[i+1] = longList.val;
                longList = longList.next;
            }
            else{
                buf[i+1] = longList.val + shortList.val;
                longList = longList.next;
                shortList = shortList.next;
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for(int i = buf.length-1; i >= 0; i--){
            if(buf[i] > 9){
                buf[i] %= 10;
                buf[i-1]++;
            }
        }

        for(int i = 0; i < buf.length; i++){
            if(i == 0 && buf[0] == 0)
                continue;
            ListNode tmp = new ListNode(buf[i]);
            cur.next = tmp;
            cur = cur.next;
        }

        return dummy.next;
    }

    int getLength(ListNode ln){

        int len = 0;
        ListNode cur = ln;

        while(cur != null){
            cur = cur.next;
            len++;
        }

        return len;
    }
}