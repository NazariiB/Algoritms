
 class Red_Black_Tree  
 {  
     private Node current_node;
     private Node parent_node;
     private Node grand_node;
     private Node great_node;
     private Node header_node;
     private static Node node_null;

     static   
     {  
         node_null = new Node(0);
         node_null.left_node_addr = node_null;  
         node_null.right_node_addr = node_null;  
     }  

     static final int BLACK = 1;      
     static final int RED   = 0;  

     public Red_Black_Tree(int negInf)  
     {  
         header_node = new Node(negInf);
         header_node.left_node_addr = node_null;  
         header_node.right_node_addr = node_null;  
     }  

     public void insert(int item )  
     {  
         current_node = parent_node = grand_node = header_node;  
         node_null.node_data = item;  
         while (current_node.node_data != item)  
         {              
             great_node = grand_node;   
             grand_node = parent_node;   
             parent_node = current_node;  
             current_node = item < current_node.node_data ? current_node.left_node_addr : current_node.right_node_addr;
             if (current_node.left_node_addr.colour_of_node == RED && current_node.right_node_addr.colour_of_node == RED)  
                 handleReorient( item );  
         }  

         if (current_node != node_null)  
             return;  
         current_node = new Node(item, node_null, node_null);

         if (item < parent_node.node_data)  
             parent_node.left_node_addr = current_node;  
         else  
             parent_node.right_node_addr = current_node;          
         handleReorient( item );  
     }  
     private void handleReorient(int item)  
     {
         current_node.colour_of_node = RED;  
         current_node.left_node_addr.colour_of_node = BLACK;  
         current_node.right_node_addr.colour_of_node = BLACK;  
   
         if (parent_node.colour_of_node == RED)     
         {  

             grand_node.colour_of_node = RED;  
             if (item < grand_node.node_data != item < parent_node.node_data)  
                 parent_node = rotate( item, grand_node );  // Start dbl rotate  
             current_node = rotate(item, great_node );  
             current_node.colour_of_node = BLACK;  
         }  

         header_node.right_node_addr.colour_of_node = BLACK;   
     }        
     private Node rotate(int item, Node parent_node)
     {  
         if(item < parent_node.node_data)  
             return parent_node.left_node_addr = item < parent_node.left_node_addr.node_data ? rotateWithleft_node_addrChild(parent_node.left_node_addr) : rotateWithright_node_addrChild(parent_node.left_node_addr) ;    
         else  
             return parent_node.right_node_addr = item < parent_node.right_node_addr.node_data ? rotateWithleft_node_addrChild(parent_node.right_node_addr) : rotateWithright_node_addrChild(parent_node.right_node_addr);    
     }  

     private Node rotateWithleft_node_addrChild(Node k2)
     {  
         Node k1 = k2.left_node_addr;
         k2.left_node_addr = k1.right_node_addr;  
         k1.right_node_addr = k2;  
         return k1;  
     }  

     private Node rotateWithright_node_addrChild(Node k1)
     {  
         Node k2 = k1.right_node_addr;
         k1.right_node_addr = k2.left_node_addr;  
         k2.left_node_addr = k1;  
         return k2;  
     }  

     public void preorder()  
     {  
         preorder(header_node.right_node_addr);  
     }  
     private void preorder(Node r)
     {  
         if (r != node_null)  
         {  
             char c = 'B';  
             if (r.colour_of_node == 0)  
                 c = 'R';  
             System.out.print(r.node_data +""+c+" ");  
             preorder(r.left_node_addr);               
             preorder(r.right_node_addr);  
         }  
     }

 }  
