/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

function ListNode(val) {
    this.val = val;
    this.next = null;
}

a = new ListNode(1);
b = new ListNode(2);
c = new ListNode(3);
d = new ListNode(4);
e = new ListNode(5);
a.next = b;
b.next = c;
c.next = d;
d.next = e;

size = (head) => {
    let size = 1;
    while(head.next !== null) {
        ++ size;
        head = head.next;
    }
    return size;
};

remove = (head, n) => {
    const position = size(head) - n;
    let index = 0;
    while(index < position) {
        if (index === position - 1) {
            head.next = head.next.next !== null ? head.next.next : null;
            break;
        }
        head = head.next;
        ++ index;
    }
}

removeNthFromEnd = (head, n) => {
   remove(head, n);
   return head;
};

