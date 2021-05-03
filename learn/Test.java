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
    public void paint(Graphics g){
        int incrementX=0;
        int yOffest=50;
        
        if(arr.size()!=0){
            incrementX= arr.size()/x;
        }
        g.drawLine(0,50,x,50);
        System.out.println(incrementX);
        for(int i=1;i<arr.size()-1;i++){
            int y1= y-(int)(arr.get(i-1)*y)+yOffest;
            int y2= y-(int)(arr.get(i)*y)+yOffest;
            g.drawLine((i-1)/incrementX,y1,i/incrementX,y2);
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
                double[] input= new double[split.length];
                for(int i=0; i<input.length;i++){
                    if(i==0){
                        input[i]=1.0;
                    }
                    else{
                        input[i]=Double.parseDouble(split[i-1]);
                    }
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
        perceptron.train(listOfExamples,700, .95);
        
        // LogisticClassifier logistic= new LogisticClassifier(listOfExamples.get(0).inputs.length);
        // logistic.train(listOfExamples,5000,0.05);
        
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