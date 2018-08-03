/**
 * 循环链表
 */
public class CircularLinkedList<E> {

    private class Node {
        public E e;
        public Node prev, next;

        public Node(E e, Node prev, Node next) {
            this.e = e;
            this.prev =prev;
            this.next = next;
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

    public CircularLinkedList() {
        dummyHead = new Node();
        dummyHead.prev = dummyHead;
        dummyHead.next = dummyHead;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e, int index) {

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }

        Node prev = dummyHead;
        for(int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        Node addNode = new Node(e, null, null);
        addNode.next = prev.next;
        prev.next.prev = addNode;
        prev.next = addNode;
        addNode.prev = prev;

        size ++;
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void addLast(E e) {
        add(e, size);
    }

    public E remove(int index) {

        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }

        Node prev = dummyHead;
        for(int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        Node next = prev.next.next;
        Node delNode = prev.next;

        prev.next = next;
        next.prev = prev;
        delNode.next = null;
        delNode.prev = null;

        size --;
        return delNode.e;
    }

    public E removeFirst(E e) {
        return remove(0);
    }

    public E removeLast(E e) {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("dummyHead -> ");
        Node cur = dummyHead.next;
        while (cur != dummyHead) {
            ret.append(cur + " -> ");
            cur = cur.next;
        }
        ret.append("dummyHead \n");

        ret.append("dummyHead");
        Node reverse = dummyHead.next;
        while (reverse != dummyHead) {
            ret.append(" <- " + reverse);
            reverse = reverse.next;
        }
        ret.append(" <- dummyHead");

        return ret.toString();
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
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
