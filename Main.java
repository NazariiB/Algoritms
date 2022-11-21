
public class Main {
    public static void main(String[] args)
    {
        RedBlackTree tree = new RedBlackTree(Integer.MIN_VALUE);
        tree.insert(10);
        tree.insert(1);
        tree.insert(20);
        tree.insert(5);
        tree.insert(19);
        tree.insert(18);
        tree.insert(6);
        tree.insert(7);
        tree.insert(16);
        tree.insert(-1);
        tree.insert(-2);
        tree.insert(-3);
        tree.insert(21);

        tree.printTree();
    }
}
