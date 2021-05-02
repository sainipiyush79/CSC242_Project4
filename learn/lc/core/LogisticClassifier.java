package learn.lc.core;

import learn.math.util.VectorOps;

public class LogisticClassifier extends LogisticLinearClassifier {
	
	public LogisticClassifier(double[] weights) {
		super(weights);
	} 
	
	public LogisticClassifier(int ninputs) {
		super(ninputs);
	}
	
	/**
	 * A LogisticClassifier uses the logistic update rule
	 * (AIMA Eq. 18.8): w_i \leftarrow w_i+\alpha(y-h_w(x)) \times h_w(x)(1-h_w(x)) \times x_i 
	 */
	public void update(double[] x, double y, double alpha) {
		// wi ← wi + α (y − hw(x))×hw(x)(1 − hw(x))×xi
		// This must be implemented by you
		for(int i=0;i<weights.length;i++){
			this.weights[i]= this.weights[i]+alpha*(y-eval(x))*eval(x)*(1-eval(x))*x[i];
		}
		
	}
	
	/**
	 * A LogisticClassifier uses a 0/1 sigmoid threshold at z=0.
	 */
	public double threshold(double z) {
		// This must be implemented by you
		return 1/(1+Math.exp(-1*z));

	}

}
