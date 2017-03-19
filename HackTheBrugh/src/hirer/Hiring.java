package hirer;

import java.util.HashMap;
import java.util.List;

public class Hiring {
	private static String[] pros;
	private static String[] cons;
	private static HashMap<String,Double> results = new HashMap<String,Double>();
	
	public static HashMap<String,Double> order(List<applicant> apps){
		for(applicant app : apps){
			results.put(String.valueOf(app.getId()), app.assess(pros, cons));
		}
		return results;
	}
}
