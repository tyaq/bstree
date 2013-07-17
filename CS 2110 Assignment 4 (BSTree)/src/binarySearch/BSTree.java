package binarySearch;

import java.util.Stack;

public class BSTree {
	
	private BTNode root; // The root of the BST
	private int size; //The number of nodes in BST
	
	public BSTree() {
		root=null;
		size=0;
	}//End Constructor
	
	/**
	 * Adds Person to tree, by running down from the root of the tree.
	 * If they are already in the tree nothing happens.
	 * This method calls to the join() recursive method.
	 * @param Person p
	 */
	public void join(Person p) {
		root = join(p, root);
		size++;
	}//End join method

	/**
	 * Adds Person to the end of the tree,
	 *  by recursively running down to the bottom of the tree.
	 * If they are already in the tree nothing happens.
	 * @param Person p
	 * @param BTNode node
	 * @return
	 */
	private BTNode join(Person p, BTNode node) {
		BTNode last = null;
		if (node == null) {//System.out.println("node=null");
		return new BTNode(p,last);}
		//Person nodePerson= node.getData();
		if (p.isLessThan(node.getData())) {//System.out.println("To the left");
		last=node;node.setLeft(join(p, node.getLeft()));}
		else if (p.isMoreThan(node.getData())) {//System.out.println("To the right");
		last=node;node.setRight(join(p, node.getRight()));}
		return node;
	}//End join Method's recursive call
	
	
	public void remove(Person p) {
		if(isEmpty())
			try {
				throw new Exception("Looking at an OPEN feild I can say " + p
						+ " is not here. (This tree is Empty.)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		BTNode node = find(p);
		BTNode parent = node.getParent();
		if(!node.hasChildren()) {//Has no children
			
			if (p.isLessThan(parent.getData())) {//System.out.println("To the left");
				parent.setLeft(null);}
			else if (p.isMoreThan(parent.getData())) {//System.out.println("To the right");
				parent.setRight(null);}
		}//End case where we have no children
		else if (node.hasLeft()) { //Has left child
			parent.setLeft(node.getLeft());
			node.getLeft().setParent(parent);
		}//End case where node only has left child
		else if (node.hasRight()) { //Has right child
			parent.setRight(node.getRight());
			node.getRight().setParent(parent);
		}//End case where node only has right child
		else if (node.hasChildren()) {//Has Children, so replace with immediately higher
			if (p.isLessThan(parent.getData())) {//System.out.println("To the left");
				parent.setLeft(node.getLeft())}
			else if (p.isMoreThan(parent.getData())) {//System.out.println("To the right");
				parent.setRight(null);}
		}
		size--;
	}
	/*
	public BTNode remove(Person p) {
		BTNode itr;
		if(!find(p).hasChildren()) {//Has no children
			
		}
		
	}*/
	
	/**
	 * Searches through the tree looking for the Person.
	 * If the tree is empty then nothing happens.
	 * This method calls to the find() recursive method.
	 * @param Person p
	 * @return
	 */
	public BTNode find(Person p) {
		if(isEmpty())
			try {
				throw new Exception("Looking at an OPEN feild I can say " + p
						+ " is not here. (This tree is Empty.)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return find(p, root);
	}
	
	/**
	 * Searches through the tree, by traveling trough the tree.
	 * If they are not found in the tree then nothing happens.
	 * @param Person p
	 * @param BTNode node
	 * @return Node where person is stored.
	 */
	private BTNode find(Person p,BTNode node) {
		if(node==null)
			try {
				throw new Exception("\"This is not the "
						+ "Person you are looking for.\"(Person not found.)");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(p.matches(node.getData())) return node;
		if(p.isMoreThan(node.getData())) return find(p,node.getRight());
		else	 return find(p,node.getLeft());
	}
	
	/**
	 * 
	 * @return Boolean telling if tree is empty.
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * 
	 * @return Size of tree.
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Probably don't need this
	 * @param size
	 */
	public void setSize(int size) {
		this.size=size;
	}
	
	public String toString() {
		String f ="Size: "+getSize()+"\n";
		//return toString("",root);
		return printTree();
	}
	
	public String printTree() {
		Stack globalStack = new Stack();
		String S="";
	      globalStack.push(root);
	      int nBlanks = 64;
	      boolean isRowEmpty = false;
	      S+=
	      "......................................................\n";
	      while(isRowEmpty==false)
	         {
	         Stack localStack = new Stack();
	         isRowEmpty = true;

	         for(int j=0; j<nBlanks; j++)
	            S+=' ';

	         while(globalStack.isEmpty()==false)
	            {
	            BTNode temp = (BTNode)globalStack.pop();
	            if(temp != null)
	               {
	               S+=temp.getData();
	               localStack.push(temp.getLeft());
	               localStack.push(temp.getRight());

	               if(temp.getLeft() != null ||
	                                   temp.getRight() != null)
	                  isRowEmpty = false;
	               }
	            else
	               {
	               S+="--";
	               localStack.push(null);
	               localStack.push(null);
	               }
	            for(int j=0; j<nBlanks*2-2; j++)
	               S+=' ';
	            }  // end while globalStack not empty
	         S+="\n";
	         nBlanks /= 2;
	         while(localStack.isEmpty()==false)
	            globalStack.push( localStack.pop() );
	         }  // end while isRowEmpty is false
	      S+=
	      "......................................................\n";
	      return S;
	}
	   private static String toString(String prefix,BTNode node) {
		      if (node == null) return "";
		      String string = prefix + node.getData().toString();
		      if (node.getRight() != null)
		         string = toString("    " + prefix, node.getRight()) + "\n" + string;
		      if (node.getLeft() != null)
		         string = string + "\n" + toString("    " + prefix, node.getLeft());
		      return string;
		   }
}//End BSTree Class
