/**
 * 双向链表
 */
public class DoubleLinkedList<E> {

    private class Node {
        public E e;
        public Node next, prev;

        public Node(E e, Node next, Node prev) {
            this.e = e;
            this.next = next;
            this.prev = prev;
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private int size;
    private Node dummyHead;

    public DoubleLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 在以node为头结点的链表的index（0-based）位置插入元素e
    public void add(E e, int index) {

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }

        Node prev = dummyHead;
        for(int i = 0; i < index; i ++) {
            prev = prev.next;
        }

        Node cur = new Node(e, null, null);
        cur.next = prev.next;
        if(prev.next != null) {
            prev.next.prev = cur;
        }
        prev.next = cur;
        cur.prev = prev;
        size ++;
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void addLast(E e) {
        add(e, size);
    }

    // 删除链表的第index（0-based）个位置的元素
    public E remove(int index) {

        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }

        Node prev = dummyHead;
        for(int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        if(delNode.next != null) {
            delNode.next.prev = prev;
        }
        delNode.next = null;
        delNode.prev = null;
        size --;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("dummyHead -> ");
        Node cur = dummyHead.next;
        while (cur != null) {
            ret.append(cur + " -> ");
            cur = cur.next;
        }

        ret.append("NULL \n");

        ret.append("NULL <- dummyHead");
        Node reverse = dummyHead.next;
        while (reverse != null) {
            ret.append(" <- " + reverse);
            reverse = reverse.next;
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(4);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.remove(list.size - 1);
        System.out.println(list);
    }
}
