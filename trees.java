 void preorder(Node root)
    {
       // Your code goes here
       if(root==null)
       {
           return;
       }
       System.out.print(root.data+" ");
       
       
       
       preorder(root.left);
       preorder(root.right);
    }

void inOrder(Node root)
    {
       // Your code goes here
       if(root==null)
       {
           return;
       }
      
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
      
       
       
    }


 void postOrder(Node root)
    {
       // Your code goes here
       if(root==null)
       {
           return;
       }
       postOrder(root.left);
       postOrder(root.right);
       System.out.print(root.data+" ");
    }



int height(Node node) 
    {
         
         if(node.right==null || node.left==null)
         {
             return 1;
         }
         return 1+Math.max(height(node.right),height(node.left));
    }   