package machine_learning;

import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.ml.train.MLTrain;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;

public class Automation_Neural {

	private static double[][] employes_data_matrix = { 
			{ 0.77, 0.12, 0.55, 0.75 }, 
			{ 0.15, 0.55, 0.763, 0.42 },
			{ 0.10, 0.12, 0.6, 0.4 }, 
			{ 0.55, 0.25, 0.13, 0.56 }, 
			{ 0.89, 0.8, 0.7, 0.9 }, 
			{ 0.76, 0.5, 0.56, 0.98 },
			{ 0.68, 0.57, 0.76, 0.18 } 
			};

	private static double[][] target_data_matrix = { 

			{ 0.0 }, 
			{ 1.0 }, 
			{ 1.0 }, 
			{ 0.0 }, 
			{ 0.0 }, 
			{ 0.0 }, 
			{ 1.0 } 
			};
	
	private static double[][] kickOrNot1_data_matrix = {
			{0.5}
	};
	
	public static void Evaluate(double[][] employee) {
		BasicNetwork n = new BasicNetwork();
		n.addLayer(new BasicLayer(null, true, 2));
		n.addLayer(new BasicLayer(new ActivationSigmoid(), true, 3));
		n.addLayer(new BasicLayer(new ActivationSigmoid(), false, 1));
		n.getStructure().finalizeStructure();
		n.reset();
		// Creating the training dataset
		MLDataSet trainingSet = new BasicMLDataSet(employes_data_matrix, target_data_matrix);

		// Training
		MLTrain train = new ResilientPropagation(n, trainingSet);

		// Training until it is good
		do {
			train.iteration();
			//System.out.println("Epoch#" + epoch + " Error:" + train.getError());
		} while (train.getError() > 0.0001);

		// Execute order 66
		System.out.println("Neural Network Results:");

		for (MLDataPair pair : trainingSet){
			final MLData output = n.compute(pair.getInput());
	//		System.out.println(pair.getInput().getData(0) + ", actual="
	//				+ output.getData(0) + ",ideal=" + pair.getIdeal().getData(0));
		}
		MLDataSet questionSet = new BasicMLDataSet(employee, kickOrNot1_data_matrix);
		for (MLDataPair pair : questionSet) {
			final MLData output = n.compute(pair.getInput());
			System.out.println(pair.getInput().getData(0) + ", actual=" + output.getData(0));
		}
	
	}

}
