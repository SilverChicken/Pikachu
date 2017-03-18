package firing_simulator;

import java.util.HashMap;
import java.util.List;

import person_input.Employee;

public class Learn_Table {	
	
	public static void Learn(List<Employee> EmployeeList) {
		int n = EmployeeList.size();
		int k = 4;
		double[][][] empMatrix = new double[n][k][1];
		for(int i = 0; i < n; i++) {
			
			double a,b,c,d;
			a = EmployeeList.get(i).averageLate();
			b = EmployeeList.get(i).averageRating();
			c = EmployeeList.get(i).averageResponse();
			d = EmployeeList.get(i).monthsWorked();
				
			double z = Math.sqrt(a*a + b*b +c*c + d*d);
			empMatrix[i][0][0] = a/z;
			empMatrix[i][1][0] = b/z;
			empMatrix[i][2][0] = c/z;
			empMatrix[i][3][0] = d/z;			
		}
		for (int i = 0; i < n; i++){
		machine_learning.Automation_Neural.Evaluate(empMatrix[i]);
		}
		
	}
		
}
