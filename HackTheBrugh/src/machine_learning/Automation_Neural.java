package machine_learning;

import java.util.HashMap;
import java.util.List;

import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.ml.train.MLTrain;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;

import person_input.Employee;

public class Automation_Neural {

	private static double[][] employes_data_matrix = { 
		{0.0015861483604271893,0.03797785280255438,0.0027757596307475814,0.9992734670691293},

		{0.00701266851928744, 0.06006198384247057, 0.008181446605835347, 0.9981364859119123},

		{0.0033942063088582006, 0.06446288656830407 ,0.005939861040501852 ,0.9978966548043111},

		{0.0029737829773318833, 0.03995378163555596, 0.003469413473553864, 0.9991910803835128},

		{0.010920801099956003 ,0.11044441367836946, 0.007644560769969201, 0.9937929000959962},

		{0.008303035819312321, 0.06637962475943394, 0.004843437561265521 ,0.9977481376206974},

		{0.004839739723400882, 0.0339962978189356, 0.0028231815053171815, 0.9994062528822821},

		{0.008827009815282744 ,0.14934483200126814, 0.015447267176744803, 0.9886250993116674},

		{0.008043920880968808, 0.03116283432875078 ,0.007038430770847708, 0.9994571694603744},

		{0.006965580633996192, 0.02851553624098064, 0.004063255369831112, 0.9995608209784537},

		{0.0028556651825265627 ,0.031856715229830565, 0.0033316093796143236, 0.999482813884297},

		{0.003282694155076737, 0.02863663652121824 ,0.002872357385692145, 0.9995803702208665},

		{0.006666066512101047, 0.1989783548568816, 0.011665616396176833, 0.979911777278854},

		{0.0015686416849087213, 0.0392415096815122 ,0.0027451229485902623, 0.9992247532868556},

		{0.004410359157519675 ,0.05939945514984628 ,0.005145419017106288 ,0.9982112893186198},

		{0.014846828571203969, 0.06521152839824636 ,0.010392779999842778 ,0.9977068799849067},

		{0.02283338912002728, 0.28176936194641344, 0.01997921548002387 ,0.9590023430411457},

		{0.0028184615614062977, 0.02742920057823411 ,0.0032882051549740143 ,0.9996143671121003},

		{0.012378180657588899 ,0.0830355902179358, 0.007220605383593526 ,0.9964435429359065}

		};

	private static double[][] target_data_matrix = { 
		{0.0},
		{1.0},
		{0.0},
		{1.0},
		{1.0},
		{1.0},
		{1.0},
		{0.0},
		{1.0},
		{1.0},
		{0.0},
		{1.0},
		{0.0},
		{0.0},
		{0.0},
		{1.0},
		{0.0},
		{1.0},
		{1.0},
		{1.0}
			};

	
	private static double[][] kickOrNot1_data_matrix = {
			{0.5}
	};
	
	public static HashMap<Integer, Double> Evaluate(double[][][] employee, List<Employee> EmployeeList, int k) {
		BasicNetwork n = new BasicNetwork();
		n.addLayer(new BasicLayer(null, true, 4));
		n.addLayer(new BasicLayer(new ActivationSigmoid(), true, 10));
		n.addLayer(new BasicLayer(new ActivationSigmoid(), true, 10));
		n.addLayer(new BasicLayer(new ActivationSigmoid(), true, 10));
		n.addLayer(new BasicLayer(new ActivationSigmoid(), true, 10));
		n.addLayer(new BasicLayer(new ActivationSigmoid(), false, 1));
		n.getStructure().finalizeStructure();
		n.reset();
		// Creating the training dataset
		MLDataSet trainingSet = new BasicMLDataSet(employes_data_matrix, target_data_matrix);

		// Training
		MLTrain train = new ResilientPropagation(n, trainingSet);

		// Training until it is good
		int mp = 0;
		do {
			train.iteration();
			System.out.println(mp);
			mp++;
			//System.out.println("Epoch#" + epoch + " Error:" + train.getError());
		} while (train.getError() > 0.01);

		// Execute order 66
		System.out.println("Neural Network Results:");
		
		HashMap<Integer, Double> results = new HashMap<Integer,Double>();

		/*for (MLDataPair pair : trainingSet){
			final MLData output = n.compute(pair.getInput());
					+ output.getData(0) + ",ideal=" + pair.getIdeal().getData(0));
		}
		*/
		for(int i = 0; i < k; i++) {
			System.out.println(i);
			MLDataSet questionSet = new BasicMLDataSet(employee[i], kickOrNot1_data_matrix);
			for (MLDataPair pair : questionSet) {
				final MLData output = n.compute(pair.getInput());
				System.out.println(pair.getInput().getData(0) +" " + pair.getInput().getData(1)+" "+pair.getInput().getData(2)+" "+pair.getInput().getData(3) + ", actual=" + output.getData(0));
				//System.out.println(emp[i][0][0] + " " + emp[i][0][1] + " " + emp[i][0][2] + " " + emp[i][0][3] + " " );
				results.put(EmployeeList.get(i).getId(), output.getData(0));
			}
		}
		return results;
	
	}

}
