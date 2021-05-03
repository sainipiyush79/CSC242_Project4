package learn;//maybe change it later

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import learn.lc.core.Example;
import learn.lc.core.PerceptronClassifier;
import learn.lc.core.DecayingLearningRateSchedule;

class Test{



    public static void main(String args[]){
        System.out.println("Hello world");
        File file = new File("learn/lc/examples/earthquake-clean.data.txt");
        ArrayList<Example> listOfExamples=new ArrayList<Example>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String full = sc.nextLine();
                String[] split= full.split(",");
                double[] input= new double[split.length]; 
                for(int i=0; i<input.length;i++){  //I KNOW WHAT THE PROBLEM IS. WE JUST NEED TO ADD A BIAS.
                    if (i==0){
                        input[i] = 1;  
                    }
                    else{
                  
                    input[i]=Double.parseDouble(split[i-1]);
                    }
                }
                double output= Double.parseDouble(split[split.length-1]);
                Example example= new Example(input,output);
                //  System.out.println(example.toString());
                listOfExamples.add(example);
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Didn't work boss");
            e.printStackTrace();
        }

        for (int i = 0; i<listOfExamples.size(); i++){
            // System.out.println(listOfExamples.get(i));
        }


// double[] myweights = {-4.9, 1.7, -1};
// PerceptronClassifier perceptron= new PerceptronClassifier(myweights);
// System.out.println( "BRO: " + perceptron.accuracy(listOfExamples));

// double[] myweights = {1, 2, 3};

PerceptronClassifier perceptron= new PerceptronClassifier(3);



// for (int i =0; i< listOfExamples.size(); i++){
//     System.out.println(listOfExamples.get(i));
// }
// System.out.println("DONKEY");



        // DecayingLearningRateSchedule alpha = new DecayingLearningRateSchedule();
        // PerceptronClassifier perceptron= new PerceptronClassifier(3);



        perceptron.train(listOfExamples,700,0.95);
        
  


    }



}




// package learn;//maybe change it later

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.Scanner;
// import java.util.ArrayList;
// import learn.lc.core.Example;
// import learn.lc.core.PerceptronClassifier;


// class Test{



//     public static void main(String args[]){
//         System.out.println("Hello world");
//         File file = new File("learn/lc/examples/earthquake-clean.data.txt");
//         ArrayList<Example> listOfExamples=new ArrayList<Example>();
//         try {
//             Scanner sc = new Scanner(file);
//             while (sc.hasNextLine()) {
//                 String full = sc.nextLine();
//                 String[] split= full.split(",");
//                 double[] input= new double[split.length-1];
//                 for(int i=0; i<input.length;i++){
//                     input[i]=Double.parseDouble(split[i]);
//                 }
//                 double output= Double.parseDouble(split[split.length-1]);
//                 Example example= new Example(input,output);
//                 listOfExamples.add(example);
//             }
//             sc.close();
//         } 
//         catch (FileNotFoundException e) {
//             System.out.println("Didn't work boss");
//             e.printStackTrace();
//         }

//         PerceptronClassifier perceptron= new PerceptronClassifier(listOfExamples.get(0).inputs.length);
//         perceptron.train(listOfExamples,5000,200);



//     }



// }