package person_input;

import java.util.HashMap;
import java.util.List;

public class modelEmployee extends Employee {

	public modelEmployee(int Id, int month, int year, List<Boolean> lateOrNot,
			List<Double> interRating, HashMap<String, String> actionToContext) {
		super(Id, month, year, lateOrNot, interRating, actionToContext);
	}
	
	//might be useful later
}
