import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {41, 22, 58, 15, 33, 50, 63, 13, 37, 42, 53};
//        int[] nums = {6, 3, 7, 2, 4, 8};
        for (int num : nums) {
            bst.add(num);
        }
        //        6
        //      /  \
        //     3    7
        //   /  \    \
        //  2   4     8
        bst.preOrder();

        System.out.println();
        Integer i = bst.floor(45);
        System.out.println(i);
        i = bst.ceil(42);
        System.out.println(i);
      /*  System.out.println(bst);*/

/*        BST<Integer> bst = new BST<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!bst.isEmpty()) {
            list.add(bst.removeMin());
        }
        System.out.println(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test completed.");*/
    }
}
