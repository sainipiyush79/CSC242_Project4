package learn;//maybe change it later

import javax.swing.*;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import learn.lc.core.Example;
import learn.lc.core.PerceptronClassifier;
import learn.lc.core.DecayingLearningRateSchedule;
import learn.lc.core.LogisticClassifier;

class Test extends JFrame{
    public ArrayList<Double> arr = new ArrayList<Double>();
    public int x=0;
    public int y=0;
    // public Test(){
    //     this.setTitle("The Cool Graph");
    //     this.setSize(500,500);
    //     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     this.setVisible(true);
    // }
    public void paint(Graphics g){
        
        for(int i=1;i<arr.size()-1;i++){
            System.out.println(arr.get(i-1)*300);
            int y1= y-(int)(arr.get(i-1)*y);
            int y2= y-(int)(arr.get(i)*y);
            g.drawLine(i-1,y1,i,y2);
        }
    }



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
                listOfExamples.add(example);
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Didn't work boss");
            e.printStackTrace();
        }
        DecayingLearningRateSchedule alpha= new DecayingLearningRateSchedule();
        //DONEEEEE
        int x=700;
        int y=500;
        PerceptronClassifier perceptron= new PerceptronClassifier(listOfExamples.get(0).inputs.length);
        perceptron.train(listOfExamples,700,0.95);

        // LogisticClassifier logistic= new LogisticClassifier(listOfExamples.get(0).inputs.length);
        // logistic.train(listOfExamples,5000,1);
        Test test= new Test();
        test.setTitle("The Cool Graph");
        test.setSize(x,y);
        test.setVisible(true);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.arr=(ArrayList<Double>)perceptron.trainArr.clone();
        test.x=x;
        test.y=y;
        test.repaint();
        




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