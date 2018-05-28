package solution;

/*
* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
* Output: 7 -> 0 -> 8
* Explanation: 342 + 465 = 807.
*/

public class AddTwoNumbers {
	
	// @author longfellow
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {  
        ListNode ret = new ListNode(0);  
        ListNode cur = ret;  
  
        int sum = 0;  
        while (true) {  
            if (l1 != null) {  
                sum += l1.val;  
                l1 = l1.next;  
            }  
            if (l2 != null) {  
                sum += l2.val;  
                l2 = l2.next;  
            }  
            cur.val = sum % 10;  
            sum /= 10;  
            if (l1 != null || l2 != null || sum != 0) {  
                cur = (cur.next = new ListNode(0));  
            } else {  
                break;  
            }  
        }  
        return ret;  
    }
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(24);
		ListNode listNode2 = new ListNode(91);
		
		ListNode resNodeList = addTwoNumbers(listNode1, listNode2);
		
		System.out.println(resNodeList);

	}
}
