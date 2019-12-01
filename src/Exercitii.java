import java.util.ArrayList;
	import java.util.Arrays;
	 
public class Exercitii {
	
	
	  public static ArrayList<String> update(ArrayList<String> species) {
	    species.add("Tyrannosaurus");
	   
	 
	    species = new ArrayList<String>(species);
	    species.add("Giganotosaurus");
	 
	    return species;
	  }
	 
	 
	  public static void main(String[] args) {
	    ArrayList<String> dinosaurs = new ArrayList<String>();
	    dinosaurs.add("Spinosaurus");
	    ArrayList<String> dinosaursUpdated = update(dinosaurs);
	 
	    System.out.println(dinosaurs.size() + dinosaursUpdated.size());    
	  }
	}

