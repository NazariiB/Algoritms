public class Node {

    private Node left, right;

    private int data;

    private boolean isBlack;

    public Node(int _data)
    {
        this( _data, null, null );
    }

    public Node(int _data, Node lt, Node rt)
    {
        left = lt;
        right = rt;
        data = _data;
        isBlack = true;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setColour(boolean black) {
        isBlack = black;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
