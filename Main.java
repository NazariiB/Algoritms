import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Red_Black_Tree red_black_tree_object = new Red_Black_Tree(Integer.MIN_VALUE);
        red_black_tree_object.insert(10);
        red_black_tree_object.insert(1);
        red_black_tree_object.insert(20);
        red_black_tree_object.insert(5);
        red_black_tree_object.insert(19);
        red_black_tree_object.insert(18);
        red_black_tree_object.insert(6);
        red_black_tree_object.insert(7);
        red_black_tree_object.insert(16);
        red_black_tree_object.insert(0);
        red_black_tree_object.insert(-1);
        red_black_tree_object.insert(-2);
        red_black_tree_object.insert(-3);
        red_black_tree_object.insert(21);

        red_black_tree_object.preorder();
    }
}
