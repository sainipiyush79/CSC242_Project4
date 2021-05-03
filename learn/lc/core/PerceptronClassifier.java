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
       Double e=eval(x);
       for (int i = 0; i<weights.length; i++){
            this.weights[i] = this.weights[i] + alpha*(y-e)*x[i];   
        }
      //  System.out.println("W0: " +this.weights[0]);
    }
   
   
  
   /**
    * A PerceptronClassifier uses a hard 0/1 threshold.
    */
   public double threshold(double z) {

       if (z>=0.0){
        // System.out.println("moo");
           return 1.0;
       }
       else {
        //    System.out.println("JEB");
           return 0.0;
       }
   }

   static public double dot(double[] x, double[] y) {
    double sum = 0.0;
    for (int i=0; i < x.length; i++) {
        sum += x[i] * y[i];
    }
    return sum;
}

   	/**
	 * For vector w of length n and vector x of length n-1,
	 * return w \cdot [1,x]. It's easier to do this in code
	 * than to constantly allocate and copy new vectors for
	 * the ``extended'' x vector.
	 */
	static public double dot1(double[] w, double[] x) {  //THIS ONE ACCOUNTS FOR THE 1 in the x vector for us, so we dont neeed to include 1 in x vetctor if we use this
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
 
