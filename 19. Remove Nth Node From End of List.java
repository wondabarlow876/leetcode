// Solution 1
// 时间复杂度：O(L)，其中 L 是链表的长度。
// 空间复杂度：O(1)。
/**
 * Definition for singly-linked list.
 * 单链表，可以是一个节点的值，也可以是一个指针，也可以是一串节点
 * public class ListNode {
 *     int val;
 *     ListNode next; // 因为next下个类型还是ListNode类型，所以用ListNode类
 *     ListNode() {} // 构造方法
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *     // 以上3行构造方法分别对应
 *     ListNode head1 = new ListNode()
 *     ListNode head1 = new ListNode(5)
 *     ListNode head1 = new ListNode(5, ListNode next)
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 初始化一个新链表，头部为0，身体和原链表一样
        ListNode dummy = new ListNode(0, head);
        // 计算出链表的长度
        int length = getLength(head);
        // 初始化一个cur链表，和dummy链表一样
        ListNode cur = dummy;
        // 遍历链表cur的每个节点， ++i 是个细节，从结果上和 i++ 一样，但性能消耗小很多
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        // 关键代码，把cur节点的下一个索引地址 改成 下一个的下一个索引地址（跳过的节点就是被删除的节点）
        cur.next = cur.next.next;
        // 答案节点 = dummy.next地址
        ListNode ans = dummy.next;
        // 返回 ans 链表
        return ans;
    }
    // 计算出链表的长度
    public int getLength(ListNode head) {
        // 定一个int变量作为长度，初始值为0
        int length = 0;
        // 尾部指针为null，所以只要指针不会null就自增
        while (head != null) {
            ++length;
            // 移动到下一个指针
            head = head.next;
        }
        return length;
    }
}


// Solution 2
// Stack First-in-last-out,我们也可以在遍历链表的同时将所有节点依次入栈。根据栈「先进后出」的原则，我们弹出栈的第 n 个节点就是需要删除的节点，并且目前栈顶的节点就是待删除节点的前驱节点。这样一来，删除操作就变得十分方便了。
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义一个头部节点 dummy，指向head
        ListNode dummy = new ListNode(0, head);
        // 定一个单链表栈 stack (double end queue)双端队列，FILO
        Deque<ListNode> stack = new LinkedList<ListNode>();
        // 初始化一个 cur 节点（指针）， 和 dummy节点一样
        ListNode cur = dummy;
        // 移动 cur 节点（指针），压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 栈是FILO，推出第n个数
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        // 定义前一个节点 值为栈顶元素的值
        // java里Stack的peek方法是返回栈顶的元素但不移除它
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
