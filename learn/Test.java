package learn;//maybe change it later

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import learn.lc.core.Example;
import learn.lc.core.PerceptronClassifier;


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
                double[] input= new double[split.length-1];
                for(int i=0; i<input.length;i++){
                    input[i]=Double.parseDouble(split[i]);
                }
                double output= Double.parseDouble(split[split.length-1]);
                Example example= new Example(input,output);
                // System.out.println(example.toString());
                listOfExamples.add(example);
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Didn't work boss");
            e.printStackTrace();
        }

        PerceptronClassifier perceptron= new PerceptronClassifier(listOfExamples.get(0).inputs.length+1);
        perceptron.train(listOfExamples,5000,1);



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