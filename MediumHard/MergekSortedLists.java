/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

  // solution 1: Divide & Conquer: O(n * lg(k))
public class Solution {
    public static ListNode mergeKLists(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }
    
    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }
    
    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
    
    // solution 2: min heap: O(n * 2 * lg(k))
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists == null || lists.length == 0)
    //     	return null;
    // 
    //     ListNode dummy = new ListNode(0);
    //     ListNode tail = dummy;
    //     
    //     PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((node1, node2) -> {
    //     	return node1.val - node2.val;
    //     });
    //     
    //     // init
    //     for(ListNode node : lists){
    //     	if(node == null)  continue;
    //     	minHeap.offer(node);
    //     }
    //     
    //     while(minHeap.size() != 0){
    //     	ListNode node = minHeap.poll();
    //     	ListNode tmp = node.next;
    //     	tail.next = node;
    //     	tail = tail.next;
    //     	if(tmp != null)
    //     		minHeap.offer(tmp);
    //     }
    //     
    //     tail.next = null;
    //     
    //     return dummy.next;
    // }
}
