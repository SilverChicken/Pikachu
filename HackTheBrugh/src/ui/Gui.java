package ui;

import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.util.HashMap;
 
// An AWT program inherits from the top-level container java.awt.Frame
public class Gui extends Frame implements ActionListener {
   private Label lblCount;    // Declare a Label component 
   private TextField IDin;  // Declare a TextField component
   private TextField likely; //Declare a TextField component
   private Button proceed;   // Declare a Button component
 
   // Constructor to setup GUI components and event handlers
   public Gui () {
	   
      setLayout(new FlowLayout());
         // "super" Frame (a Container) sets its layout to FlowLayout, which arranges
         // the components from left-to-right, and flow to next row from top-to-bottom.
 
      lblCount = new Label("Please add an ID");  // construct the Label component
      add(lblCount);                    // "super" Frame adds Label
 
      IDin = new TextField("", 10); // construct the TextField component
      IDin.setEditable(true);       // set to write
      add(IDin);                     // "super" Frame adds TextField
 
      proceed = new Button("ok");   // construct the Button component
      add(proceed); // "super" Frame adds Button
      
      likely = new TextField("",10);
      likely.setEditable(false);
      add(likely);
      
 
      proceed.addActionListener(this);
         // btnCount is the source object that fires ActionEvent when clicked.
         // The source add "this" instance as an ActionEvent listener, which provides
         //  an ActionEvent handler called actionPerformed().
         // Clicking btnCount invokes actionPerformed().
 
      setTitle("You are fired!");  // "super" Frame sets its title
      setSize(450, 300);        // "super" Frame sets its initial window size
 
      // For inspecting the components/container objects
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
 
      setVisible(true);         // "super" Frame shows
      
 
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
      

   }
 
   static // The entry main() method
   
   HashMap<Integer, Double> results = new HashMap<Integer,Double>();
   
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an instance
      Gui app = new Gui();
	  results = person_input.Random_data_sheet.mainish();
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
		   likely.setText(String.valueOf((Math.round(results.get(Id) * 100.0) / 100.0)));
	   }
   }
}