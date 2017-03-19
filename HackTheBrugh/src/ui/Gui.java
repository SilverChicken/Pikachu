package ui;

import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;

import person_input.Employee;
 
// An AWT program inherits from the top-level container java.awt.Frame
public class Gui extends Frame implements ActionListener {
   private Label lblCount;    // Declare a Label component 
   private Label lblCount2;
   private String lbl1 = "Very satisfactory";
   private String lbl2 = "Underperforming";
   private String lbl3 = "Unsatisfactory";
   private TextField IDin;  // Declare a TextField component
   private TextField likely; //Declare a TextField component
   private TextField annoc;
   private Button proceed;   // Declare a Button component
   private Button close;
   
   private Label  lblColum1;
   private TextField Colum1;
   private Label  lblColum2;
   private TextField Colum2;
   private Label  lblColum3;
   private TextField Colum3;
   private Label  lblColum4;
   private TextField Colum4;
   
   private Button good;
   private Button bad;
   
   
   // Constructor to setup GUI components and event handlers
   public Gui () {
      setLayout(new FlowLayout());
      lblCount = new Label("Please add an ID");  // construct the Label component
      add(lblCount);                    
 
      IDin = new TextField("", 10); // construct the TextField component
      IDin.setEditable(true);       
      add(IDin);                    
 
      proceed = new Button("ok");   // construct the Button component
      add(proceed); 
      
      close = new Button("close");
      add(close);
      
      lblCount2 = new Label("Numerical Evaluation of Employee Performance:");
      add(lblCount2); 
      
      likely = new TextField("",10);
      likely.setEditable(false);
      add(likely);
      
      annoc = new TextField("",30);
      annoc.setEditable(false);
      add(annoc);
    
      lblColum1 = new Label("Late:");
      add(lblColum1);
      Colum1 = new TextField("",10);
      Colum1.setEditable(false);
      add(Colum1);
      
      lblColum2 = new Label("Rating:");
      add(lblColum2);
      Colum2 = new TextField("",10);
      Colum2.setEditable(false);
      add(Colum2);

      lblColum3 = new Label("Response:");
      add(lblColum3);
      Colum3 = new TextField("",10);
      Colum3.setEditable(false);
      add(Colum3);

      lblColum4 = new Label("Time Spent at the company:");
      add(lblColum4);
      Colum4 = new TextField("",10);
      Colum4.setEditable(false);
      add(Colum4);
      
      good = new Button("Good worker");
      add(good);
      bad = new Button("Bad worker");
      add(bad);
    
      close.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e)
    	    {
    	        //Execute when button is pressed
    	        System.exit(0);
    	    }
    	});
      
      good.addActionListener(new ActionListener(){
    	 public void actionPerformed(ActionEvent d)
    	 {
    		 if(annoc.getText() == lbl1){
    			 int id = Integer.parseInt(likely.getText());
    			 double[][] new_target = {{1.0}};
    			 String[] data = datas.get(id).toString().split(" ");
    			 double[][] new_data = {{Double.parseDouble(data[0]),Double.parseDouble(data[1]),Double.parseDouble(data[2]),Double.parseDouble(data[3])}};
    		 }
    	 }
      });
      bad.addActionListener(new ActionListener(){
     	 public void actionPerformed(ActionEvent f)
     	 {
     		 if(annoc.getText() == lbl3 | annoc.getText() == lbl2){
     			 int id = Integer.parseInt(likely.getText());
     			 double[][] new_target = {{0.0}};
     			 String[] data = datas.get(id).toString().split(" ");
     			 double[][] new_data = {{Double.parseDouble(data[0]),Double.parseDouble(data[1]),Double.parseDouble(data[2]),Double.parseDouble(data[3])}};
     		 }
     	 }
       }); 
      
      
      
      
      proceed.addActionListener(this);
      
      
         
 
      setTitle("You are fired!");  // "super" Frame sets its title
      setSize(360, 250);        // "super" Frame sets its initial window size
 
     
 
      setVisible(true);         // "super" Frame shows

   }
   

   static // The entry main() method
   
   HashMap<Integer, Double> results = new HashMap<Integer,Double>();
   
   static
   HashMap<Integer, Double[]> datas = new HashMap<Integer,Double[]>();
   public static void main(String[] args) {
	   
      // Invoke the constructor to setup the GUI, by allocating an instance
      Gui app = new Gui();
	  results = person_input.Random_data_sheet.mainish();
	  for(Employee e : person_input.Random_data_sheet.getEmps()){
		  datas.put(e.getId(), new Double[]{e.averageLate(), e.averageRating(), e.averageResponse(), e.monthsWorked()} );
	  }
	  
         // or simply "new AWTCounter();" for an anonymous instance
	  for(Integer k : results.keySet()){
	  System.out.println(k);
	  System.out.println(results.get(k));
	  
	  
	  }
   }
   // ActionEvent handler - Called back upon button-click.
   @Override
   public void actionPerformed(ActionEvent evt) {
	   String ID = IDin.getText();
	   int Id = Integer.parseInt(ID);
	   if(results.get(Id) != null){
		   double u = 1 - (Math.round(results.get(Id) * 100.0) / 100.0);
		   likely.setText(String.valueOf(u));
		   
		   if(u > 0.6) 
			   annoc.setText(lbl1);
		   else if( u > 0.2) 
			   annoc.setText(lbl2);
		   else 
			   annoc.setText(lbl3);
	   }
	   double a=datas.get(Id)[0]; 
	   double b=datas.get(Id)[1]; 
	   double c=datas.get(Id)[2]; 
	   double d=datas.get(Id)[3]; 
	   
	   double late = (Math.round(a * 100.0) / 100.0);
	   double rating = (Math.round(b * 100.0) / 100.0);
	   double response = (Math.round(c * 100.0) / 100.0);
	   double time = (Math.round(d * 100.0) / 100.0);
	   
	   Colum1.setText(String.valueOf(late));
	   Colum2.setText(String.valueOf(rating));
	   Colum3.setText(String.valueOf(response));
	   Colum4.setText(String.valueOf(time));
	   
	   
	   
	   
   }
}