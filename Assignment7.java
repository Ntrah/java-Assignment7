/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author agyapongg.
 */
public class Assignment7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] math=new int[n];
        int[] reading=new int[n];
        int[] totalScore=new int[n];
        readSatscores(math,reading,n);
        System.out.println(Arrays.toString(math));
        System.out.println(Arrays.toString(reading));
        sumScores(math,reading,totalScore,n);
        System.out.println(Arrays.toString(totalScore));
        printOutput(math,reading,totalScore,n);
        scan.close();
    }
    /**
     * 
     * @param array1  an integer array for holding the first column in the data file
     * @param array2 an integer array for holding the second column in the data file
     * @param k   an integer representing the number of lines of data to read in
     * @throws FileNotFoundException 
     */
    public static void readSatscores(int []array1,int[]array2,int k) throws FileNotFoundException{
        File infile=new File("input.txt");
        Scanner sc=new Scanner(infile);
        for (int i = 0; i < k && sc.hasNextInt(); i++) {
            array1[i]=sc.nextInt();
            array2[i] = sc.nextInt();
        }
        sc.close();
    }
    
    /**
     * 
     * @param mathScores  an integer array holding the math scores
     * @param readingScores an integer array holding the reading scores
     * @param totalScores  an integer array that will get filled with the sum of corresponding
elements of array1 and array2
     * @param k an integer representing the number of elements in the arrays
     */
    public static void sumScores(int[]mathScores, int[]readingScores,int[]totalScores,int k){
        for(int i=0;i< k;i++){
            totalScores[i]=mathScores[i]+readingScores[i];
        }
        
    
    }/**
     * 
     * @param mathScores  an integer array holding the math scores
     * @param readingScores an integer array holding the reading scores
     * @param totalScores an integer array holding each student’s total score
     * @param k an integer representing the number of elements in the arrays
     * @throws FileNotFoundException 
     */
    public static void printOutput(int[]mathScores, int[]readingScores,int[]totalScores,int k) throws FileNotFoundException{
         PrintWriter outfile = new PrintWriter("output.txt");
         outfile.printf("%s %10s  %10s  %20s\n","Math","Reading", "Total", "MaxArea");
         for (int i=0;i<k;i++){
         outfile.printf("%d  %10d  %10d  %20s\n",mathScores[i],readingScores[i], totalScores[i], mathScores[i] == readingScores[i]? "Math/Reading" : (mathScores[i] > readingScores[i] ? "Math" : "Reading")  );
         }
         outfile.close();
         
    
    }
    
}
