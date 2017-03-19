package hirer;

import java.util.HashMap;
import java.util.List;

public class Hiring {
	private static String[] pros;
	private static String[] cons;
	private static HashMap<Integer,Double> results = new HashMap<Integer,Double>();
	
	public static void order(List<applicant> apps){
		for(applicant app : apps){
			results.put(app.getId(), app.assess(pros, cons));
		}
	}
}
