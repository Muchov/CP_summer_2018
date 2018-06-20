package pl.waw.sgh.Homeworks;

//Please write a program that given a file or folder calculates:
//- the number of all files and folders (also in their subfolders)
//- the total size of all files and folders.
//
//Hint: Use recursion to implement the calculation on subfolders.

import java.io.File;
import java.util.Scanner;

public class Homework4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
        Here we allow scanner to ask for the directory
        */

        System.out.println("Please enter the path to Directory:");
        String Directory = sc.nextLine();
        System.out.println("Your Directory is:" + Directory);

        File file = new File(Directory);

        boolean isDir = file.isDirectory();
        if (isDir) {

            /*
            This code specifies what will be printed. If we specified the path to the directory,
            the code will execute the process of determining: space, no of files and no of folders.
            But what if we specify a path to a file? Then it will calculate its size, and say that
            we specified a path to one file.
            */


            int numberOfFiles = countFiles(file);
            double spaceTaken = countSpaceTakenByFiles(file);
            int numberOfFolders = countFolders(file);
            System.out.println("Space taken = " + spaceTaken);
            System.out.println("Number of files = " + numberOfFiles);
            System.out.println("Number of folders = " + numberOfFolders);

        } else {

            System.out.println("Space taken = " + file.length()
                    + ". Number of files = 1. The path leads to just one file.");

        }
    }

    /*
    to calculate files we create "CountFiles".
    Increment (++) and decrement (—) operators
    in Java programming let you easily add 1 to, or subtract 1 from, a variable.
    */

    public static int countFiles(File file) {
        File[] files = file.listFiles();
        int countNumber = 0;

        for (File f : files) {
            if (f.isDirectory())

                countNumber += countFiles(f);

            else

                countNumber++;

        }
        return countNumber;
    }

    /*
    to calculate space taken we create "CountSpaceTakenByFiles"
    */

    public static double countSpaceTakenByFiles(File file) {
        File[] files = file.listFiles();
        double countSpace = 0d;
        for (File f : files) {
            if (f.isDirectory())

                countSpace += countSpaceTakenByFiles(f);

            else

                countSpace += f.length();

        }
        return countSpace;
    }

   /*
    to calculate folders we create "Count Folders".
    Our programs counts files, but it can detect a folder (directory).
    So if it encounters a directory, it "adds" 1 to countFolders and goes further.
    */

    public static int countFolders(File file) {
        File[] files = file.listFiles();
        int countFolders = 0;
        for (File f : files) {
            if (f.isDirectory()) {

                countFolders++;
                countFolders(f);

            }
        }
        return countFolders;
    }
}