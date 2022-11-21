
 public class RedBlackTree
 {  
     private Node current;
     private Node parent;
     private Node grandNode;
     private Node grandGrandNode;
     private Node root;
     private static Node nullNode;

     static   
     {  
         nullNode = new Node(0);
         nullNode.setLeft(nullNode);
         nullNode.setRight(nullNode);
     }  

     static final boolean BLACK = true;
     static final boolean RED = false;


     public RedBlackTree(int negInf)
     {
         root = new Node(negInf);
         root.setLeft(nullNode);
         root.setRight(nullNode);
     }

     public void insert(int item )  
     {  
         current = parent = grandNode = root;
         nullNode.setData(item);
         while (current.getData() != item)
         {              
             grandGrandNode = grandNode;
             grandNode = parent;
             parent = current;
             current = item < current.getData() ? current.getLeft() : current.getRight();
             if (!current.getLeft().isBlack() && !current.getRight().isBlack())
                 balance( item );
         }  

         current = new Node(item, nullNode, nullNode);

         if (item < parent.getData())
             parent.setLeft(current);
         else  
             parent.setRight(current);
         balance( item );
     }  
     private void balance(int item)
     {
         current.setColour(RED);
         current.getLeft().setColour(BLACK);
         current.getRight().setColour(BLACK);
         if (!parent.isBlack())
         {
             grandNode.setColour(RED);
             if (item < grandNode.getData() != item < parent.getData())
                 parent = rotate( item, grandNode);
             current = rotate(item, grandGrandNode);
             current.setColour(BLACK);
         }
         root.getRight().setColour(BLACK);
     }        
     private Node rotate(int item, Node node)
     {  
         if(item < node.getData()) {
             node.setLeft(item < node.getLeft().getData() ? leftRotate(node.getLeft()) : rightRotate(node.getLeft())) ;
         } else {
             node.setRight(item < node.getRight().getData() ? leftRotate(node.getRight()) : rightRotate(node.getRight()));
         }
         return node;
     }

     private Node leftRotate(Node k2)
     {  
         Node k1 = k2.getLeft();
         k2.setLeft(k1.getRight());
         k1.setRight(k2);
         return k1;  
     }  

     private Node rightRotate(Node k1)
     {  
         Node k2 = k1.getRight();
         k1.setRight( k2.getLeft());
         k2.setLeft(k1);
         return k2;  
     }  

     public void printTree() {
         print("", root);
     }
     private void print(String prefix, Node node) {
         if (node != nullNode) {
             print(prefix + "     ", node.getRight());
             if(node.getData() == Integer.MIN_VALUE)
                 return;
             System.out.println (prefix + node.getData() + ' ' + (node.isBlack() ? "B" : "R"));
             print(prefix + "     ", node.getLeft());
         }
     }

 }