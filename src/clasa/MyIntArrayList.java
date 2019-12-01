 package clasa;
import java.util.Arrays;
public class MyIntArrayList {
	private int[] elements;
	  private int size;
	 
	  public MyIntArrayList() {
	    this(10);
	  }
	 
	  public MyIntArrayList(int initialCapacity) {
	    this.elements = new int[initialCapacity];
	  }
	  

	  MyIntArrayList(MyIntArrayList c) {
		  this.size = c.size;
		  this.elements = new int[c.size];
		  for(int i = 0; i < c.size; i++) {
			  this.elements[i] = c.get(i);
		  }
	  }
	 
	  public boolean add(int e) {
	    if (this.size == this.elements.length) {
	      this.elements = Arrays.copyOf(this.elements, this.size * 2);
	    }
	 
	    this.elements[size] = e;
	    this.size++;
	 
	    return true;
	  }
	 
	  public int size() {
	    return this.size;
	  }
	 
	  public int indexOf(int e) {
	    for (int i=0; i<this.size; i++) {
	      if (this.elements[i] == e) {
	        return i;
	      }
	    }
	    return -1;
	  }
	 
	  public int removeElementAtIndex(int index) {
	    if (index < 0 || index >= this.size) {
	      // should throw IndexOutOfBoundsException
	      System.out.println("Throwing IndexOutOfBoundsException when trying to" +
	                         " remove element at position " + index);
	      return -1;
	    }
	 
	    int removedElement = this.elements[index];
	    for (int i=index; i<this.size; i++) {
	      this.elements[i] = this.elements[i+1];
	    }
	    this.size--;
	 
	    return removedElement;
	  }
	 
	  public void clear() {
	    this.size = 0;
	  }
	 
	  public int set(int index, int e) {
	    if (index < 0 || index >= this.size) {
	      // should throw IndexOutOfBoundsException
	      System.out.println("Throwing IndexOutOfBoundsException when trying to set" +
	                         " the element " + e + " at position " + index);
	      return -1;
	    }
	 
	    int replacedElement = this.elements[index];
	    this.elements[index] = e;
	    return replacedElement;
	  }
	  
	  public void add(int index, int element) {
		  if (this.size == this.elements.length) {
		      this.elements = Arrays.copyOf(this.elements, this.size * 2);
		    }
		 
		    this.elements[index] = element;
		    this.size++;
	  }
	  
	  public int get(int index) {
		  if (index < 0 || index >= this.size) {
		      // should throw IndexOutOfBoundsException
		      System.out.println("Throwing IndexOutOfBoundsException when trying to get" +
		                         " the element " + " at position " + index);
		      return -1;
		    }
		 return elements[index];
	  }
	  
	  public int lastIndexOf(int e) {
		  for(int i = this.size - 1; i >= 0; i--) {
			  if(this.elements[i] == e) {
				  return i;
			  }
		  }
			return -1;
	  }
	  
	  public boolean remove(int e) {
		  boolean isHappening = false;
		  int aux = 0;
		  for(int i = 0; i < this.size; i++) {
			  if(this.elements[i] == e) {
				  aux = i;
				  isHappening = true;
				  this.elements[i] = this.elements[i + 1];
				  break;
			  }
		  }
		  if(isHappening) {
			  for(int i = aux + 1; i < this.size; i++) {
				  this.elements[i] = this.elements[i + 1];
			  }
			  this.size--;
		  }
		  return isHappening;
	  }
	  
	  public boolean addAll(MyIntArrayList c) {
			int[] newArray = new int[this.size + c.size];
			int counterForThisArray = 0;
			int counterForC = 0;
			for(int i = 0; i < newArray.length; i++) {
				if(counterForThisArray < this.size) {
					newArray[i] = this.elements[counterForThisArray];
					counterForThisArray++;
				} else {
					newArray[i] = c.get(counterForC);
					counterForC++;
					if(counterForC == c.size) {
						break;
					}
				}
			}
			this.elements = newArray;
			this.size=newArray.length;
			return true;
		}
		
		public boolean addAll(int index, MyIntArrayList c) {
			int[] newArray = new int[this.size + c.size];
			int counterForC = 0;
			int counterFromIndex = index;
			for(int i = 0; i < index; i++) {
				newArray[i] = this.elements[i];
			}
			for(int i = index; i < newArray.length; i++) {
				if(counterForC < c.size) {
					newArray[i] = c.get(counterForC);
					counterForC++;
				} else {
					newArray[i] = this.elements[counterFromIndex];
					counterFromIndex++;
				}
			}
			this.elements = Arrays.copyOf(newArray, this.size + c.size);
			this.size = this.size + c.size;
			return true;
		}
		
		public int[] toArray() {
			int[] array = Arrays.copyOf(this.elements, this.size);
			return array;
		}
		
		public void ensureCapacity(int minCapacity) {
			this.elements = Arrays.copyOf(this.elements, minCapacity);
		}
		
		public void trimToSize() {
			this.elements = Arrays.copyOf(this.elements, this.size);
			if(this.elements.length == 0) {
				this.elements = Arrays.copyOf(this.elements, 1);
			}
		}	  
}
