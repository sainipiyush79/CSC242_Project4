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
import java.util.Scanner;

class Test extends JFrame{
    public ArrayList<Double> arr = new ArrayList<Double>();
    public int x=0;
    public int y=0;
    public Test(ArrayList<Double> arr){
        this.arr= arr;
    }

    public void paint(Graphics g){
        int incrementX=1;
        int yOffest=50;
        if(arr.size()!=0&&x!=0){
            incrementX= (arr.size()/x)+1;
            if(incrementX<=0){
                incrementX=1;
            }
        }
        g.drawLine(0,yOffest,x,yOffest);
        for(int i=1;i<arr.size()-1;i++){
            int y1= y-(int)(arr.get(i-1)*y)+yOffest;
            int y2= y-(int)(arr.get(i)*y)+yOffest;
            g.drawLine((i-1)/incrementX,y1,i/incrementX,y2);     
        }
    }



    public static void main(String args[]){
        String fileName="earth-noisy";
        String classifer="logistic";
        int steps=5000;
        double alphaNum=0.05;

        fileName= args[0];
        classifer=args[1];
        steps= Integer.parseInt(args[2]);
        alphaNum= Double.parseDouble(args[3]);

        System.out.println(steps+" "+alphaNum);

        if(fileName.equals("earth-clean")){
            fileName="earthquake-clean.data.txt";
        }
        else if(fileName.equals("earth-noisy")){
            fileName="earthquake-noisy.data.txt";
        }    
        else if(fileName.equals("house")){
            fileName="house-votes-84.data.num.txt";
        }
        else{
            System.out.println("filename not valid");
            return;
        }
        
        File file = new File("learn/lc/examples/"+fileName);

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
        //measurements for graph canvas
        int x=700;
        int y=500;
        //constants
        DecayingLearningRateSchedule alpha= new DecayingLearningRateSchedule();
        ArrayList<Double> paintArr = new ArrayList<Double>();
        
        

        if(classifer.equals("perceptron")){
            PerceptronClassifier perceptron= new PerceptronClassifier(listOfExamples.get(0).inputs.length);
            if(alphaNum==0.0){
                perceptron.train(listOfExamples,steps,alpha);
            }
            else{
                perceptron.train(listOfExamples,steps,alphaNum);
            }
            paintArr=(ArrayList<Double>)perceptron.trainArr.clone();

        }       
        else if(classifer.equals("logistic")){
            LogisticClassifier logistic= new LogisticClassifier(listOfExamples.get(0).inputs.length);
            if(alphaNum==0.0){
                logistic.train(listOfExamples,steps,alpha);
            }
            else{
                logistic.train(listOfExamples,steps,alphaNum);
            }
            paintArr=(ArrayList<Double>)logistic.trainArr.clone();
        }
        else{
            System.out.println("Not a valid classifier");
            return;
        }

        Test test= new Test(paintArr);
        test.setTitle("The Cool Graph");
        test.setSize(x,y);
        test.x=x;
        test.y=y;
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);

    }



}