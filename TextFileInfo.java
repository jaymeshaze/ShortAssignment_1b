
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kris Hayes
 */
public class TextFileInfo implements java.io.Serializable {

    private int numChars;
    private int numWords;
    private double sumNumbers;
    private String fileName;
    private String[] fileContents;
    
    public TextFileInfo() {
    }

    public TextFileInfo(String fileName) {
        this.fileName = fileName;
    }
    
    public void fileInfo() {
        convertToArray();
        wordCount();
        charCount();
        numSum();
        System.out.println("File Info:");
        System.out.println("-----------------------");
        System.out.println("Number of words: " + numWords);
        System.out.println("Number of characters: " + numChars);
        System.out.println("Sum of all numbers: " + sumNumbers);
        
    }
    
    private void convertToArray(){
        try(Scanner input = new Scanner(new File(fileName))){
            StringBuilder builder = new StringBuilder();
            while(input.hasNextLine()){
                builder.append(input.nextLine());
                builder.append(" ");
            }
            this.fileContents = builder.toString().split(" ");
            System.out.println(Arrays.toString(fileContents));
        }catch(FileNotFoundException ex){
            System.out.println(ex);
        }
    }
    
    private void wordCount(){
        numWords = fileContents.length;
    }
    
    private void charCount(){
        try(Scanner input = new Scanner(new File(fileName))){
            StringBuilder builder = new StringBuilder();
            while(input.hasNextLine()){
                builder.append(input.nextLine());
                builder.append(" ");
            }
            String totalContents = builder.toString();
            char[] allcharacters = totalContents.toCharArray();
            this.numChars = allcharacters.length;
            
        }catch(FileNotFoundException ex){
            System.out.println(ex);
        }
    }
    
    private void numSum(){
        for(int i = 0; i < this.fileContents.length; i++){
            if(isNumeric(fileContents[i]) == true){
                sumNumbers += Double.parseDouble(fileContents[i]);
            }
                
        }
    }
    
    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public int getNumChars() {
        return numChars;
    }

    public void setNumChars(int numChars) {
        this.numChars = numChars;
    }

    public int getNumWords() {
        return numWords;
    }

    public void setNumWords(int numWords) {
        this.numWords = numWords;
    }

    public double getSumNumbers() {
        return sumNumbers;
    }

    public void setSumNumbers(double sumNumbers) {
        this.sumNumbers = sumNumbers;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[] getFileContents() {
        return fileContents;
    }

    public void setFileContents(String[] fileContents) {
        this.fileContents = fileContents;
    }
    
}

