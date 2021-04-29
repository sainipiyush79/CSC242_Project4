package learn.lc.core;
 
import java.util.Arrays;
 
import learn.math.util.VectorOps;
 
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
       System.out.println("HIE");
       // wi ←wi+α(y−hw(x))×xi
 
       for (int i = 0; i<x.length; i++){
           weights[i] = weights[i] + alpha(y-threshold(VectorOps.dot1(weights, x)))*x[i];
               }
 
       // This must be implemented by you
   }
  
   /**
    * A PerceptronClassifier uses a hard 0/1 threshold.
    */
   public double threshold(double z) {
       if (z>=0){
           return 1;
       }
       else {
           return 0;
       }
       // This must be implemented by you
   }
  
}
 
