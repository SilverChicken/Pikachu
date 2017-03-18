package person_input;

import java.util.HashMap;
import java.util.List;

import jdk.nashorn.internal.runtime.regexp.joni.MatcherFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Employee {
	
	private int Id;
	private int month,yearsWorked;
	private List<Boolean> lateOrNot = new ArrayList<Boolean>();
	private List<Double> interRating = new ArrayList<Double>();
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
	
	/**
	 * Calculates the average ratings given to an employee
	 * and returns the normalised value.
	 * @return A value between 0.0 - 1.0
	 */
	public double averageRating() {
		double i = 0;
		double n = (double)interRating.size();
		for(double d : interRating) {
			i += d;
		}
		return (i / n) / MAX_RATING;	
	}
	
	public double averageResponse() {
		return 0.5; //for now, idk yo
	}
}
