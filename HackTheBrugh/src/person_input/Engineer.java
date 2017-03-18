package person_input;

import java.util.HashMap;
import java.util.List;

public class Engineer extends Employee{

	public Engineer(int Id, int month, int year, List<Boolean> lateOrNot, List<Double> interRating,
			HashMap<String, String> actionToContext) {
		super(Id, month, year, lateOrNot, interRating, actionToContext);
	}

	public double averageResponse() {
		//Return something
		return 0.0;
	}
}
