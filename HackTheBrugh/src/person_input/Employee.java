package person_input;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Employee {
	
	int Id;
	int month,yearsWorked;
	List<Boolean> lateOrNot = new ArrayList<Boolean>();
	List<Double> interRating = new ArrayList<Double>();
	HashMap<String,String> actionToContext = new HashMap<String,String>();
	
	
	public Employee(int Id, int month, int year, List<Boolean> lateOrNot, List<Double> interRating, HashMap<String,String> actionToContext) {
		this.Id = Id;
		this.month = month;
		this.yearsWorked = year;
		this.lateOrNot = lateOrNot;
		this.interRating = interRating;
		this.actionToContext = actionToContext;
	}
	
	public double averageLate() {
		double i = 0;
		double n = (double)lateOrNot.size();
		for(boolean b : lateOrNot) {
			i += (b? 1 : 0);
		}
		return i / n;
	}
	
	public double averageRating() {
		double i = 0;
		double n = (double)interRating.size();
		for(double d : interRating) {
			i += d;
		}
		return i / n;
	}
	
	public double averageResponse() {
		
	}
	
	
		
	
}
