package chapter_2_listproblem;

/*	给定链表头结点head，实现删除链表的中间节点函数
	例如：
	1->2，删除节点1
	1->2->3，删除节点2
	1->2->3->4，删除节点2
	1->2->3->4->5，删除节点3
	...
	进阶：
	给定链表头结点head、整数a和b，实现删除位于a/b处节点的函数
	例如：
	链表：1->2->3->4->5，假设a/b值为r
	如果r等于0，不删除任何节点
	如果r在区间(0,1/5]上，删除节点1
	如果r在区间(1/5,2/5]上，删除节点2
	如果r在区间(2/5,3/5]上，删除节点3
	如果r在区间(3/5,4/5]上，删除节点4
	如果r在区间(4/5,1]上，删除节点5
	如果r大于1，不删除任何节点
*/
public class Problem_03_RemoveNodeByRatio {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node removeMidNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		if (head.next.next == null) {
			return head.next;
		}
		Node pre = head;
		Node cur = head.next.next;
		while (cur.next != null && cur.next.next != null) {
			pre = pre.next;
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		return head;
	}

	public static Node removeByRatio(Node head, int a, int b) {
		if (a < 1 || a > b) {
			return head;
		}
		int n = 0;
		Node cur = head;
		while (cur != null) {
			n++;
			cur = cur.next;
		}
		n = (int) Math.ceil(((double) (a * n)) / (double) b);
		if (n == 1) {
			head = head.next;
		}
		if (n > 1) {
			cur = head;
			while (--n != 1) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
	}

	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		printLinkedList(head);
		head = removeMidNode(head);
		printLinkedList(head);
		head = removeByRatio(head, 2, 5);
		printLinkedList(head);
		head = removeByRatio(head, 1, 3);
		printLinkedList(head);

	}

}
