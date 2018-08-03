public class LinkedListByRecursion<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private int size;
    private Node dummyHead;

    public LinkedListByRecursion() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 在以node为头结点的链表的index（0-based）位置插入元素e，递归算法
    public void add(E e, int index) {

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }

        Node head = dummyHead.next;
        head = add(head, e, index);
        dummyHead.next = head;
        size ++;
    }

    private Node add(Node node, E e, int index) {
        if(index == 0) {
            return new Node(e, node);
        }

        node.next = add(node.next, e, index - 1);
        return  node;
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void addLast(E e ) {
        add(e, size);
    }

    // 获取链表的第index（0-based）个位置的元素
    public E get(int index) {

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }

        return get(dummyHead.next, index);
    }

    private E get(Node node, int index) {
        if(index == 0) {
            return node.e;
        }

        return get(node.next, index - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    // 修改链表中第index(0-based)位置的元素为e
    public void set(int index, E e) {

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }

        set(dummyHead.next, index, e);
    }

    private void set(Node node, int index, E e) {
        if(index == 0) {
            node.e = e;
        }

        set(node.next, index - 1, e);
    }

    // 查找链表中是否有元素
    public boolean contains(E e) {
        return contains(dummyHead.next, e);
    }

    private boolean contains(Node node, E e) {

        if(node.next == null) {
            return false;
        }
        if(node.e.equals(e)) {
            return true;
        }

        return contains(node.next, e);
    }

    // 从链表中删除index（0-based）位置的元素，返回删除的元素
    public E remove(int index) {

        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }

        E ret = remove(dummyHead, index);
        size --;
        return ret;
    }

    private E remove(Node node, int index) {
        if(index == 0) {
            Node delNode = node.next;
            node.next = node.next.next;
            delNode.next = null;
            return delNode.e;
        }

        return remove(node.next, index - 1);
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    // 从链表中删除元素e
    public void removeElement(E e) {
        dummyHead.next = removeElement(dummyHead.next, e);
    }

    private Node removeElement(Node node, E e) {
        if(node == null) {
            return null;
        }

        node.next = removeElement(node.next, e);
        if(node.e.equals(e)) {
            size --;
            return node.next;
        } else {
            return node;
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("listR: ");
        Node cur = dummyHead.next;
        while (cur != null) {
            ret.append(cur.e + "->");
            cur = cur.next;
        }
        ret.append("NULL");
        return ret.toString();
    }

    public static void main(String[] args) {
        LinkedListByRecursion<Integer> list = new LinkedListByRecursion<>();
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(4);
        System.out.println(list);
        list.removeElement(0);
        System.out.println(list);
    }
}
