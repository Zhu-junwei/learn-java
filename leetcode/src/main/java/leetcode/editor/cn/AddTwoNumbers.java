package leetcode.editor.cn;

/**
 * 2 两数相加
 */
public class AddTwoNumbers{
    public static void main(String[] args) {
         Solution solution = new AddTwoNumbers().new Solution();
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
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
        ListNode pre = new ListNode();
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}