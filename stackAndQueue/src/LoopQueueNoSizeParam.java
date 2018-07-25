/**
 * 不声明size变量，只是用front和tail来实现一个循环队列
 */
public class LoopQueueNoSizeParam<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;

    public LoopQueueNoSizeParam(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueueNoSizeParam() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if((getRealTail() - front) == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        int realTail = getRealTail();
        for(int i = 0; i < realTail - front; i ++) {
            newData[i] = data[(i + front) % data.length];
        }
        tail = realTail - front;
        front = 0;
        data = newData;
    }

    // 因为是循环队列，tail可能在front前面。
    // 假设没有循环，tail应该在的实际位置。
    private int getRealTail() {
        return tail < front ? tail + data.length : tail;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return getRealTail() - front;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        int size = getRealTail() - front;

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueueNoSizeParam<Integer> queue = new LoopQueueNoSizeParam<>();
        for(int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }

        }
    }
}
