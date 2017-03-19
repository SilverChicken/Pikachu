package hirer;

import java.util.HashMap;
import java.util.List;

import machine_learning.Automation_Effect;

public class applicant {
	private int Id;
	private String resume = "resume";
	private String interview = "Hello, good day, goodbye and farewell";
	
	public applicant(int Id, In resume, In interview ){
		this.Id = Id;
		if(resume.scanner != null) {
			this.resume = resume.readAll();
		}
		if(resume.scanner != null){
			this.interview = interview.readAll(); //.split(" ");
		}
	}
	public String getResume() {
		return resume;
	}
	
	public String getInterview() {
		return interview;
	}
	
	public int getId() {
		return Id;
	}
	public static double[][] vecCreat(String appli){
		String[] wordsLooked = new String[] {"work", "family", "drunk", "collaborate", "help"};
		double[] vector = {0.0,0.0,0.0,0.0,0.0}; 
		double[][] normalized = { {0.0,0.0,0.0,0.0,0.0} }; 
		String[] splitelt = appli.split(" ");
		for(int i = 0; i<5;i++){
			for(int j = 0; j<splitelt.length;j++){
				if (wordsLooked[i].equals(splitelt[j])){
					
					vector[i]= vector[i] + 1.0;
				}
			}
		}
		
		double z = Math.sqrt(vector[0]*vector[0]+vector[1]*vector[1]+vector[2]*vector[2]+vector[3]*vector[3]+vector[4]*vector[4]);
		normalized[0][0] = vector[0]/z;
		normalized[0][1] = vector[1]/z;
		normalized[0][2] = vector[2]/z;
		normalized[0][3] = vector[3]/z;
		normalized[0][4] = vector[4]/z;
		
		
		return normalized;
	}
	
	public static HashMap<String,Double> MatCreat(String[] applis,String[] applier){
		HashMap <String,double[][]>  dataMat = new HashMap<String,double[][]>();
		
		for (int i = 0; i<applis.length;i++){
			double[][] vect = vecCreat(applis[i]);
			dataMat.put(applier[i], vect);
			
			System.out.println(applier[i] + " " + vect[0][0] + " " + vect[0][1] + " " + vect[0][2] + " " + vect[0][3]+ " " + vect[0][4] );
		}
		
		return Automation_Effect.Eval(dataMat);
	}
	
	
	/*public double assess(String[] pros, String[] cons) {
		double good = 0;
		double bad = 0;
		for(String s : pros){
			good += (resume.split(s).length) + (interview.split(s).length) - 2;
		}
		good = good / (double)pros.length;
	
		for(String s : cons){
			bad += (resume.split(s).length) + (interview.split(s).length) - 2;
		}
		bad = bad / (double)cons.length; 
		
		return good - bad;
	}*/
}
