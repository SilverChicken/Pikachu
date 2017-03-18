package person_input;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Employee {
	
	String Id = "";
	List<Boolean> lateOrNot = new ArrayList<Boolean>();
	List<Integer> interRating = new ArrayList<Integer>();
	HashMap<String,String> actionToContext = new HashMap<String,String>();
	
	
	public Employee(String Id, List<Boolean> lateOrNot, List<Integer> interRating, HashMap<String,String> actionToContext) {
		this.Id = Id;
		this.lateOrNot = lateOrNot;
		this.interRating = interRating;
		this.actionToContext = actionToContext;
	}
		
	
}
