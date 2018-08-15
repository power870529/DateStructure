import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if(node == null) {
            size ++;
            return new Node(e);
        }

        if(node.e.compareTo(e) > 0) {
            node.left = add(node.left, e);
        } else if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if(node == null) {
            return false;
        }

        if(node.e.compareTo(e) > 0) {
            return contains(node.left, e);
        } else if (node.e.compareTo(e) < 0) {
            return contains(node.right, e);
        } else {
            return true;
        }
    }

    // 二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 二分搜索树的非递归前序遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node top = stack.pop();
            System.out.println(top.e);
            if(top.right != null) {
                stack.push(top.right);
            }
            if(top.left != null) {
                stack.push(top.left);
            }
        }
    }

    // 二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二分搜索树的层序遍历
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimum() {
        if(root == null) {
            throw new IllegalArgumentException("BST is empty");
        }

        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return maximum(root).e;
    }
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    // 删除二分搜索树的最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 删除二分搜索树中的最大值
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {

        if (node == null) {
            return null;
        }

        if(node.e.compareTo(e) > 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (node.e.compareTo(e) < 0) {
            node.right = remove(node.right, e);
            return node;
        }

        // 待删除的左子树为空
        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
            // 待删除的右子树为空
        } else if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
            // 待删除的左右子树都不为空
            // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
        } else {
            Node s = node.right ;
            while (s.left != null) {
                s = s.left;
            }
            s.right = removeMin(node.right);
            s.left = node.left;
            node.left = null;
            node.right = null;
            return s;
        }
    }

    // 查询比元素e小的节点中的最大值
    public E floor(E e) {
        Node ret = floor(root, e);
        if (ret != null) {
            return ret.e;
        } else {
            return null;
        }
    }

    private Node floor(Node node, E e) {
        if (node == null) {
            return null;
        }

        // 如果该节点的值比e大，则去该节点的左子树寻找
        if (node.e.compareTo(e) > 0) {
            return floor(node.left, e);
            // 该节点的值等于元素e，则节点的左子树中的最大值就是要返回的值
        } else if (e.compareTo(node.e) == 0) {
            return maximum(node.left);
            // 该节点的值小于元素e
        } else {
            // 如果右子树的最小值大于等于元素e，则该节点就是要返回的值
            if (node.right == null || e.compareTo(minimum(node.right).e) <= 0 ) {
                return node;
                // 如果右子树的最小值小于元素e，说明该节点不是比元素e小的节点中的最大值
                // 继续在节点的右子树中寻找
            } else {
                return floor(node.right, e);
            }
        }
    }

    // 查询比元素e大的节点中的最小值
    public E ceil(E e) {
        Node ret = ceil(root, e);
        if (ret != null) {
            return ret.e;
        } else {
            return null;
        }
    }

    private Node ceil(Node node, E e) {
        if (node == null) {
            return node;
        }

        // 如果该节点的值比e小，则去该节点的右子树寻找
        if (node.e.compareTo(e) < 0) {
            return ceil(node.right, e);
            // 如果该节点的值等于e，则返回该节点右子树中的最小值
        } else if (node.e.compareTo(e) == 0) {
            return minimum(node.right);
            // 该节点的值比e大
        } else {
            // 如果该节点没有左子树或者该节点左子树的最大值小于等于e，则该节点就是要找的值
            if (node.left == null || maximum(node.left).e.compareTo(e) <= 0) {
                return node;
                // 否则，说明该节点的左子树中还有比e大的节点，继续在该节点的左子树中寻找
            } else {
                return ceil(node.left, e);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if(node == null) {
            res.append(generateDepth(depth) + "null \n");
            return;
        }

        res.append(generateDepth(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepth(int depth) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < depth; i ++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
