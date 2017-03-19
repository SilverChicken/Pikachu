package hirer;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.util.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;

import ui.Gui;

public class HireGui extends Frame implements ActionListener {
	   private Label lblCount;    // Declare a Label component 
	   private Label lblCount2;
	  // private String lbl1 = "Shows great potential";
	  //private String lbl2 = "Ought";
	   private TextField IDin;  // Declare a TextField component
	   private TextField likely; //Declare a TextField component
	   private TextField annoc;
	   private Button proceed;   // Declare a Button component
	   private Button close;
	   private Button addapp;
	   
	   private Label  lblColum1;
	 //  private TextField Colum1;
	 //  private Label  lblColum2;
	 //  private TextField Colum2;
	 //  private Label  lblColum3;
	 //  private TextField Colum3;
	 //  private Label  lblColum4;
	 //  private TextField Colum4;
	   
	   // Constructor to setup GUI components and event handlers
	   public HireGui () {
	      setLayout(new FlowLayout());
	      lblCount = new Label("Enter applicant ID");  // construct the Label component
	      add(lblCount);                    
	 
	      IDin = new TextField("", 10); // construct the TextField component
	      IDin.setEditable(true);       
	      add(IDin);                    
	 
	      proceed = new Button("Launch ranking");   // construct the Button component
	      add(proceed); 
	      
	      close = new Button("close");
	      add(close);
	      
	      lblCount2 = new Label("Resume");
	      add(lblCount2); 
	      
	      likely = new TextField("",30);
	      likely.setEditable(true);
	      add(likely);
	      
	      lblColum1 = new Label("Interview Transcript");
	      add(lblColum1);
	      
	      annoc = new TextField("",30);
	      annoc.setEditable(true);
	      add(annoc);
	      
	      addapp = new Button("add applicant");
	      add(addapp);
	    
	      /*
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
	      */
	      
	      
	      
	      addapp.addActionListener(new ActionListener() {
	    	    public void actionPerformed(ActionEvent e)
	    	    {
	    	        //Execute when button is pressed
	    	    	In resu = new In(likely.getText());
	    	    	In interv = new In(annoc.getText());
	    	    	
	    	        apps.add(new applicant(Integer.parseInt(IDin.getText()), resu, interv));
	    	        
	    	        IDin.setText("");
	    	        likely.setText("");
	    	        annoc.setText("");
	    	    }
	    	});
	    
	      close.addActionListener(new ActionListener() {
	    	    public void actionPerformed(ActionEvent e)
	    	    {
	    	        //Execute when button is pressed
	    	        System.exit(0);
	    	    }
	    	});
	      
	      proceed.addActionListener(this);
	      
	      
	         
	 
	      setTitle("You are hired?");  // "super" Frame sets its title
	      setSize(450, 300);        // "super" Frame sets its initial window size
	 
	     
	 
	      setVisible(true);         // "super" Frame shows

	   }
	   

	   static // The entry main() method
	   List<applicant> apps = new ArrayList<applicant>();
	   HashMap<Integer, Double> results = new HashMap<Integer,Double>();
	   
	   public static void main(String[] args) {
		   
	      // Invoke the constructor to setup the GUI, by allocating an instance
	      Gui app = new Gui();
	         // or simply "new AWTCounter();" for an anonymous instance
		  
	   }
	   // ActionEvent handler - Called back upon button-click.
	   @Override
	   public void actionPerformed(ActionEvent evt) {
		   results = Hiring.order(apps);
		   
		   }
		   
		   
		   
		   
		   
	   }
