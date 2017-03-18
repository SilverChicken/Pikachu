package firing_simulator;

import java.util.HashMap;
import java.util.List;

import person_input.Employee;

public class Learn_Table {	

	HashMap<Employee, Float> table = new HashMap<Employee, Float>();
	
	public static void Learn(List<Employee> EmployeeList) {
		int n = EmployeeList.size();
		int k = 4;
		double[][] empMatrix = new double[n][k];
		for(int i = 0; i < n; i++) {
			
			double a,b,c,d;
			a = EmployeeList.get(i).averageLate();
			b = EmployeeList.get(i).averageRating();
			c = EmployeeList.get(i).averageResponse();
			d = EmployeeList.get(i).monthsWorked();
				
			double z = Math.sqrt(a*a + b*b +c*c + d*d);
			empMatrix[i][0] = a/z;
			empMatrix[i][1] = b/z;
			empMatrix[i][2] = c/z;
			empMatrix[i][3] = d/z;			
		}
		
		machine_learning.Automation_Neural.main(empMatrix);
	}
	
}
