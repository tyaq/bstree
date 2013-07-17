package binarySearch;

public class BTNode {
	
	private Person data;
	private BTNode left,right;
	
	//Constructor Method
	public BTNode(Person p) {
		data = p;
	}//End Constructor Method
	
	//Mutator and Accessory Methods
	
	public Person getData ( ) { 
		return data ; 
	}//End getData Method
	
	public void setData ( Person p ) { 
		 data = p ; 
	}//End setData Method
	
	public BTNode getLeft () { 
		return left ; 
	}//End getLeft Method
	
	public void setLeft ( BTNode L ) {
		left = L ;
	}//End setLeft Method
	
	public BTNode getRight ( ) {
		return right ; 
	}//End getRight Method
	
	public void setRight ( BTNode R ) { 
		right = R ; 
	}//End setRight Method
	
	public String toString() {
		String s=""+data+"\n\tLeft: ";
		if(left!=null){s+=left.getData();}
		s+="\n\tRight: ";
		if(right!=null){s+=right.getData();}
		s+="\n";
		return s;
	}
	
}//End BSNode Class
