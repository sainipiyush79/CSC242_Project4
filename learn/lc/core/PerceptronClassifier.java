package learn.lc.core;
 
import java.util.Arrays;
// import learn.lc.core; 
 
 
public class PerceptronClassifier extends LinearClassifier {
   public PerceptronClassifier(double[] weights) {
       super(weights);
   }
  
   public PerceptronClassifier(int ninputs) {
       super(ninputs);
   }
  
   /**
    * A PerceptronClassifier uses the perceptron learning rule
    * (AIMA Eq. 18.7): w_i \leftarrow w_i+\alpha(y-h_w(x)) \times x_i
    */
 
    //mesay hw(x)=Threshold(w·x)
   public void update(double[] x, double y, double alpha) {
       // wi ←wi+α(y−hw(x))×xi
       for (int i = 0; i<weights.length; i++){
            this.weights[i] = this.weights[i] + alpha*(y-eval(x))*x[i];
        }
   }
  
   /**
    * A PerceptronClassifier uses a hard 0/1 threshold.
    */
   public double threshold(double z) {
       if (z>=0.0){
           return 1.0;
       }
       else {
           return 0.0;
       }
   }

   	/**
	 * For vector w of length n and vector x of length n-1,
	 * return w \cdot [1,x]. It's easier to do this in code
	 * than to constantly allocate and copy new vectors for
	 * the ``extended'' x vector.
	 */
	static public double dot1(double[] w, double[] x) {
		double sum = w[0];
		for (int i=1; i < w.length; i++) {
			sum += w[i] * x[i-1];
		}
		return sum;
	}



   public static void main(String args[]){
    System.out.println("hi");
   }
  
}
 
