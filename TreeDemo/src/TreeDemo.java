class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }
}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      //process, go left, go right
      //base case
      if(root == null) {
         return;
      }

      //process node
      System.out.print(root.value + " ,");
      //go left recursively
      preOrderTraversal(root.left);
      //go right recursively
      preOrderTraversal(root.right);
   }

   
   
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      //go left, process, go right
      //base case
      if(root == null) {
         return;
      }
      //go left recursively
      inOrderTraversal(root.left);
      //process node
      System.out.print(root.value + " ,");
      //go right recursively
      inOrderTraversal(root.right);
   }
   
   
   
   /*
   post-order traversal
   */
//   public void postOrderTraversal(Node root){
//      //implement me
//   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
//   public boolean find(Node root, int key){
//	  //implement me
//      return false;
//   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
//   public int getMin(Node root){
//      //implement me
//   }
  
  
  
   /*
   a method to find the node in the tree
   with the largest key
   */
   public int getMax(Node root){
	  // recursively move right down the tree until no right child exists
      //base case
      if (root.right == null) {
         return root.value;
      } else {
         return getMax(root.right);
      }
   }
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();  //had to modify test cases with t1.root and directly update the root initially as Node parameter was required but not added to main code insert()  calls
      t1.root= t1.insert(t1.root,24);
      t1.insert(t1.root,80);
      t1.insert(t1.root,18);
      t1.insert(t1.root,9);
      t1.insert(t1.root,90);
      t1.insert(t1.root,22);
      System.out.println("Max value is: " + t1.getMax(t1.root)); //added to test function
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
      t1.preOrderTraversal(t1.root);
      System.out.println();
   }  
}