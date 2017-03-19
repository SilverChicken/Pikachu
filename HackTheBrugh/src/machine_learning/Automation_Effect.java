package machine_learning;

import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.ml.train.MLTrain;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;

public class Automation_Effect {
	private static double[][] training_data ={
		
	};
	private static double[][] target_data = {
		
	};

	public static void main(String[] args) {
		BasicNetwork n = new BasicNetwork();
		n.addLayer(new BasicLayer(null,false,2));
		n.addLayer(new BasicLayer(new ActivationSigmoid(),true,3));
		n.addLayer(new BasicLayer(new ActivationSigmoid(),true,3));
		n.addLayer(new BasicLayer(new ActivationSigmoid(),false,1));
		n.getStructure().finalizeStructure();
		n.reset();
		
		MLDataSet trainingSet = new BasicMLDataSet(training_data,target_data);
		MLTrain train = new ResilientPropagation(n, trainingSet);

		int mp = 0;
		do {
			train.iteration();
			mp++;
		} while (train.getError() > 0.01);

	}

}
