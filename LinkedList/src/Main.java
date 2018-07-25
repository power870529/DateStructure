public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 5; i ++) {
            list.addFirst(i);
            System.out.println(list);
        }

        list.add(666, 2);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);
    }
}
