public class ArrayUsingGenerics<E> {

    private int size;
    private E data[];

    public ArrayUsingGenerics(int capacity) {
        this.size = 0;
        this.data = (E[]) new Object[capacity];
    }

    public ArrayUsingGenerics() {
        this(10);
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.data.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // 向数组末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    // 在所有元素前添加一个元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 在第index个位置插入一个新元素e
    public void add(int index, E e) {
         if(size == data.length) {
             throw new IllegalArgumentException("AddLast failed, Array is full");
         }
         if(index < 0 || index > size) {
             throw new IllegalArgumentException("Add failed, index is illegal");
         }
         for(int i = size - 1; i >= index; i--) {
             data[i + 1] = data[i];
        }
        data[index] = e;
         size ++;
    }

    // 获取index索引位置的元素
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e) {

        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        data[index] = e;
    }

    // 查找数组中是否存在某个元素e
    public boolean contains(E e) {
        for(int i = 0; i < size; i ++) {
            if(data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，返回-1
    public int find(E e) {
         for(int i = 0; i < size; i ++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 删除index位置的元素, 返回删除的元素
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illagel");
        }
        E ret = data[index];
        for(int i = index; i < size - 1; i ++) {
            data[i] = data[i + 1];
        }
        size --;
        return ret;
    }

    // 从数组中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for(int i = 0; i < size; i ++) {
            res.append(data[i]);
            if(i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
