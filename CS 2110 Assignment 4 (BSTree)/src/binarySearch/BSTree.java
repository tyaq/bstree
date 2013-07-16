package binarySearch;

public class BSTree {
	
	private BTNode root; // The root of the BST
	private int size; //The number of nodes in BST
	
	public BSTree() {
		root=null;
		size=0;
	}//End Constructor
	
	/**
    * Join. Nothing happens if the Person is already in the BST.
    */
   public void join(Person p) {
      root = join(p, root);
      size++;
   }

   private static BTNode join(Person p, BTNode node) {
      if (node == null) new BTNode(p);
      int compare = p.compareTo(node.getData());
      if (compare < 0) node.setLeft(join(p, node.getLeft()));
      else if (compare > 0) node.setRight(join(p, node.getRight()));
      return node;
   }//End join Method
   
   public int getSize() {
	   return size;
   }
   
   //Probably don't need
   public void setSize(int size) {
	   this.size=size;
   }
	
}//End BSTree Class
