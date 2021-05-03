Abdelmonem Khedr, Jordan Altomare, Piyush Saini
Project 4 CSC 242

We have implmented:
    -Preceptron in the file PreceptronClassifier.java which also implments LinearClassifier.java.  
        -utilized method "accuracy" for Preceptron
    -Logistic in the LogisticClassifier.java which also implments LogisticLinearClassifier.java. 
        -utilized method "squaredErrorPerSample" for Logistic

To graph the data points we utilized JFrame. Please follow thedirections below to compile and run our program. 

1. Be sure to be inside the CSC242_Project folder but outside learn
2. Type javac learn/Test.java to compile
3. Type java learn.Test {fileName} {classifier} {steps} {alpha}
    3.a.The file name can be any of the following:(make sure its lowercase)
        earth-clean
        earth-noisy
        house
    3.b. The classifier can be any of the following:(make sure its lowercase)
        preceptron
        logistic
    3.c. Enter any number of steps to run alogrithim
    3.d. For a constant alpha put a double bettween 0 and 1 and for a decaying alpha put 0

An example of a valid running command: 
    java learn.Test earth-clean logistic 5000 0.05

For the graphs and more information about compiling, please look at the project report.
Please reach out to me at akhedr@u.rochester.edu if you have any questions.

Thank you for reading! 
-Team Awesome :)
