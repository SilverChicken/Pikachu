package person_input;

import person_input.Employee;
import firing_simulator.Learn_Table;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LIKHITHASAI
 */
public class Random_data_sheet {

    private static ArrayList<Employee> emps = new ArrayList<Employee>();	 
    private static int count=0;
	public static int idgen()
	{
		Random rand = new Random();
		int min = 1000;
	        int idg= min+count;
                count++;
		return idg;
                
	}
	public static int yeargen()
	{
		Random rand = new Random();
		int min = 2000;
		int max = 2016;
	        int yearg=(int) ((Math.random() * (max - min)) + min);
		return yearg;
	} 
	public static int monthgen()
	{
		Random rand = new Random();
		int min = 0;
		int max = 11;
	        int monthg=(int)((Math.random() * max) + min);
		return monthg;
	} 
	public static List<Boolean> boolgen()
	{
		Random randomBoolean = new Random();
		ArrayList<Boolean> lateornot = new ArrayList<Boolean>();
                for (int i = 0; i < 40; i++) 
		{
            		lateornot.add(randomBoolean.nextBoolean());
        	}
		return lateornot;
	} 
	public static List<Double> interratinggen()
	{
		Random rand = new Random();
		ArrayList<Double> interrating = new ArrayList<Double>();
	        for (int i = 0; i < 40; i++) 
		{
            		interrating.add(10 * rand.nextDouble());
        	}
		return interrating;
	} 
	public static HashMap<Integer, Double> mainish() {
		for(int i=0;i<40;i++)
                {
                    emps.add(new Employee(idgen(),monthgen(),yeargen(),boolgen(),interratinggen(),new HashMap<String,String>()));
                }
		return Learn_Table.Learn(emps);
	}
}