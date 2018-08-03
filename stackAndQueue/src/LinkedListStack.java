public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        this.list = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.getFirst();
    }

    @Override
    public E peek() {
        return list.removeFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("Stack:");
        ret.append(list);
        return ret.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> list = new LinkedListStack<>();
        for(int i = 0; i < 5; i ++) {
            list.push(i);
            System.out.println(list);
        }

        list.peek();
        System.out.println(list);
    }
}
