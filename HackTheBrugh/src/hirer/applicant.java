package hirer;

public class applicant {
	private int Id;
	private String resume;
	private String interview;
	
	public applicant(int Id, In resume, In interview ){
		if(resume.scanner != null){
			this.resume = resume.readAll();
		}
		if(interview.scanner != null){
			this.interview = interview.readAll(); //.split(" ");
		}
	}
	
	public int getId() {
		return Id;
	}
	
	public double assess(String[] pros, String[] cons) {
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
	}
}
