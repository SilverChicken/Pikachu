package machine_learning;

import hirer.applicant;

import java.util.HashMap;

import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.ml.train.MLTrain;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;

public class Automation_Effect {
	private static double[][] training_data ={
		 {0.3779644730092272,0.7559289460184544,0.0,0.3779644730092272,0.3779644730092272},
		 {0.0 			 ,0.2581988897471611 ,0.5163977794943222 , 0.2581988897471611 , 0.7745966692414834},
		 {0.0 			, 0.3333333333333333 ,0.6666666666666666 , 0.0 		,    0.666666666666},
		 {0.4082482904638631 ,	 0.4082482904638631 ,0.0 	,	0.0 		,    0.816496580927},
		 {0.8017837257372732 	, 0.2672612419124244, 0.5345224838248488 , 0.0 		,    0.0},
		 {0.5547001962252291 	, 0.5547001962252291, 0.2773500981126146 , 0.0 		,    0.554700196225},
		 {0.0 			, 0.6324555320336759, 0.6324555320336759 , 0.3162277660168379 , 0.31622776601683794},
		 {0.0 			, 0.2357022603955158 ,0.4714045207910317 , 0.7071067811865476 , 0.47140452079103173},
		 {0.0 			, 0.0 	,	    0.577350269189    ,  0.5773502691896258 , 0.5773502691896258},
		 {0.0 		,	 0.213200716355610 , 0.2132007163556104  ,0.4264014327112208 , 0.8528028654224417},
		 {0.75		,	 0.25 		,    0.25 	,	0.25  		,    0.5},
		 {0.0 		,	 0.0 	,	    0.18257418583505536 ,0.3651483716701107 , 0.9128709291752769},
		 {0.9805806756909202   , 0.0 		 ,   0.19611613513818404, 0.0 	,    0.0},
		 {0.5547001962252291  ,  0.0 		   , 0.8320502943378437,  0.0 	,	    0.0},
		 {0.0 			, 0.4714045207910317, 0.47140452079103173, 0.23570226039551587, 0.7071067811865476},
		{0.0 			, 0.6255432421712244, 0.6255432421712244 , 0.41702882811414954 ,0.20851441405707477}
	};
	private static double[][] target_data = {
		{1.0},
		{0.0},
		{0.0},
		{1.0},
		{0.0},
		{1.0},
		{0.0},
		{0.0},
		{0.0},
		{0.0},
		{1.0},
		{1.0},
		{1.0},
		{0.0},
		{0.0},
		{0.0}
		
	};

	public static HashMap<String,Double> Eval( HashMap<String,double[][]> attList ) {
		
		HashMap<String,Double> result = new HashMap<String,Double>();
		
		BasicNetwork n = new BasicNetwork();
		n.addLayer(new BasicLayer(null,false,5));
		n.addLayer(new BasicLayer(new ActivationSigmoid(), true, 10));
		n.addLayer(new BasicLayer(new ActivationSigmoid(), true, 10));
		n.addLayer(new BasicLayer(new ActivationSigmoid(), true, 10));
		n.addLayer(new BasicLayer(new ActivationSigmoid(), true, 10));
		n.addLayer(new BasicLayer(new ActivationSigmoid(), false, 1));
		n.getStructure().finalizeStructure();
		n.reset();
		
		MLDataSet trainingSet = new BasicMLDataSet(training_data,target_data);
		MLTrain train = new ResilientPropagation(n, trainingSet);

		int mp = 0;
		do {
			System.out.println(mp);
			train.iteration();
			mp++;
			if(mp > 2000) return Eval(attList);
		} while (train.getError() > 0.01);
		
		double[][] predictValue = {{0.5}};
		double[][] applying = {{}};
		int i = 0;
		for(String s : attList.keySet()) {
			System.out.println(i);
			MLDataSet questionSet = new BasicMLDataSet(attList.get(s), predictValue);
			i++;
			for (MLDataPair pair : questionSet) {
				final MLData output = n.compute(pair.getInput());
				
				System.out.println(pair.getInput().getData(0) +" " + pair.getInput().getData(1)+" "+pair.getInput().getData(2)+" "+pair.getInput().getData(3)+" "+pair.getInput().getData(4) + ", actual=" + output.getData(0));
				result.put(s,output.getData(0));
			}
			
		}
		return result;

	}

}
