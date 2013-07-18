package binarySearch;

public class BSTTest {
	public static void main(String[] args) {
		Person a = new Person();//1
		Person b = new Person();//2
		Person c = new Person();//3
		Person d = new Person();//4
		Person e = new Person();//5
		Person f = new Person();//6
		Person g = new Person();//7
		Person h = new Person();//8
		Person i = new Person();//9
		BSTree t =new BSTree();
		t.join(b);
		t.join(i);
		System.out.println(t);
		t.remove(b);
		System.out.println(t);
		//System.out.println(t.find(i));
		//System.out.println(t.find(a));
		//System.out.println(t.find(c));
		//System.out.println(t.find(b));
		
		
	}
}
