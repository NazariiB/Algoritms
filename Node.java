public class Node {

    Node left_node_addr, right_node_addr;

    int node_data;

    int colour_of_node;

    public Node(int thenode_data)
    {
        this( thenode_data, null, null );
    }

    public Node(int thenode_data, Node lt, Node rt)
    {
        left_node_addr = lt;
        right_node_addr = rt;
        node_data = thenode_data;
        colour_of_node = 1;
    }
}
