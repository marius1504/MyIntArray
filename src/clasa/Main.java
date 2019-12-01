package clasa;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyIntArrayList array1 = new MyIntArrayList(2);
		
		array1.add(0);
		array1.add(1);
		array1.add(2);
		array1.add(3);
		array1.add(0, 10);
		array1.add(9);
		MyIntArrayList array2 = new MyIntArrayList(array1);
		array2.set(3, 20);
		array1.addAll(3, array2);
		System.out.println(array1);
		System.out.println(array2);
	}

}
