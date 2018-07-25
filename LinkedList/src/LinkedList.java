public class LinkedList<E> {

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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表的index（0-based）位置添加新的元素e
    // 在链表中不是一个常用操作，练习用
    public void add(E e, int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }

        Node prev = dummyHead;
        for(int i = 0; i < index; i ++) {
            prev = prev.next;
        }

//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;
        prev.next = new Node(e, prev.next);
        size ++;
    }

    // 向链表头添加元素e
    public void addFirst(E e) {
        add(e, 0);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(e, size);
    }

    // 获取链表的第index（0-based）个位置的元素
    // 在链表中不是一个常用操作，练习用
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }

        Node cur = dummyHead.next;
        for(int i = 0; i < index; i ++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取链表最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 获取链表的第index（0-based）个位置的元素
    // 在链表中不是一个常用的操作，练习用
    public void set(int index, E e) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }

        Node cur = dummyHead.next;
        for(int i = 0; i < index; i ++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {

        Node cur = dummyHead.next;
        while (cur != null) {
            if(cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 获取链表的第index（0-based）个位置的元素
    // 在链表中不是一个常用的操作，练习用
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
        delNode.next = null;
        size --;

        return delNode.e;
    }

    // 从链表中删除第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("dummyHead ->");
        Node cur = dummyHead.next;
        while (cur != null) {
            ret.append(cur + " ->");
            cur = cur.next;
        }

//        for(Node cur = dummyHead.next; cur != null; cur = cur.next) {
//            ret.append(cur + " ->");
//        }
        ret.append("NULL");
        return ret.toString();
    }
}
