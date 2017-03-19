package firing_simulator;

import java.util.HashMap;
import java.util.List;

import person_input.Employee;

public class Learn_Table {	
	
	public static HashMap<Integer, Double> Learn(List<Employee> EmployeeList) {
		int n = EmployeeList.size();
		int k = 4;
		double[][][] empMatrix = new double[n][1][k];
		double[][][] emp = new double[n][1][k];
		for(int i = 0; i < n; i++) {
			
			double a,b,c,d;
			a = EmployeeList.get(i).averageLate();
			b = EmployeeList.get(i).averageRating();
			c = EmployeeList.get(i).averageResponse();
			d = EmployeeList.get(i).monthsWorked();
			
			emp[i][0][0] = a;
			emp[i][0][1] = b;
			emp[i][0][2] = c;
			emp[i][0][3] = d;
				
			double z = Math.sqrt(a*a + b*b +c*c + d*d);
			empMatrix[i][0][0] = a/z;
			empMatrix[i][0][1] = b/z;
			empMatrix[i][0][2] = c/z;
			empMatrix[i][0][3] = d/z;	
			
		}
		
		return machine_learning.Automation_Neural.Evaluate(empMatrix,EmployeeList, n );
		
	}
		
}
