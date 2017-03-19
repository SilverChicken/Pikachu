package person_input;

import java.util.HashMap;
import java.util.List;

public class Scientist extends Employee{
	
	HashMap<String,String> procedure = new HashMap<String,String>(); 

	public Scientist(int Id, int month, int year, List<Boolean> lateOrNot, List<Double> interRating,
			HashMap<String, String> actionToContext) {
		super(Id, month, year, lateOrNot, interRating, actionToContext);
	}

	public double averageResponse() {
		double i = 0;
		for(String key : actionToContext.keySet()){
			if (procedure.get(key) == null){
				i += 0.5;
			}
			else if (procedure.get(key) == actionToContext.get(key)){
				i += 1;
			}
			else
			{
				i += 0;
			}
		}
		return i / (double)actionToContext.size();
	}
}