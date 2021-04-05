package com.hzy.algorithm.other;

/**
 * 给定一个链表: 1->2->3->4->5, 和 n = 2. 当删除了倒数第二个节点后，链表变为
    1->2->3->5. 说明： 给定的 n 保证是有效的。 要求： 只允许对链表进行一次遍历。
 */
public class ListNodeDemo {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = removeNthFromEnd(head, 3);
        printList(head);
    }

    public static ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode first = dumy;
        ListNode second = dumy;
        // 两个链表起点相同，先移动第一个链表 n 个位置产生差额
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        // 再同时移动两个链表，则第二个链表落后第一个链表 N 个节点到达末尾，
        // 即一链到达末尾时，二链到达倒数N位置
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dumy.next;
    }

    /**
     * 打印链表
     */
    public static void printList(ListNode head){
        if(null == head){
            System.out.println("null listNode");
            return;
        }
        while(head.next != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        //打印最后一个值
        System.out.println(head.val);
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}
