package person_input;

import person_input.Employee;
import firing_simulator.Learn_Table;
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
    private ArrayList<Employee> emps = new ArrayList<Employee>();
	private ArrayList<Boolean> lateornot = new ArrayList<Boolean>();
        private ArrayList<Double> interrating = new ArrayList<Double>();
	public int idgen()
	{
		Random rand = new Random();
		int min = 1000;
		int max = 9999;
	        int idg=rand.nextInt(rand.nextInt((max - min) + 1));
		return idg;
	}
	public int yeargen()
	{
		Random rand = new Random();
		int min = 2000;
		int max = 2016;
	        int yearg=rand.nextInt(rand.nextInt((max - min) + 1));
		return yearg;
	} 
	public int monthgen()
	{
		Random rand = new Random();
		int min = 0;
		int max = 11;
	        int monthg=rand.nextInt(rand.nextInt((max - min) + 1));
		return monthg;
	} 
	public ArrayList<Boolean> boolgen()
	{
		Random randomBoolean = new Random();
                for (int i = 0; i < 40; i++) 
		{
            		lateornot.add(randomBoolean.nextBoolean());
        	}
		return lateornot;
	} 
	public ArrayList<Double> interratinggen()
	{
		Random rand = new Random();
	        for (int i = 0; i < 40; i++) 
		{
            		interrating.add(10 * rand.nextDouble());
        	}
		return interrating;
	} 
	public static void main (String[] args) {
		for(int i=0;i<40;i++)
                {
                    emps.add((idgen(),monthgen(),yeargen(),boolgen(),interratinggen(),new Hashmap<String,String>));
                }
		Learn_Table.Learn(emps);
	}
}
