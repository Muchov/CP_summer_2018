package pl.waw.sgh;

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

        System.out.println("Enter the Path for Directory/Folder Name");
        String Directory = sc.nextLine();
        System.out.println("Your Directory/folder is :" + Directory);

        File file = new File(Directory);

        boolean isDir = file.isDirectory();
        if (isDir) {
            int numberOfFiles = countFiles(file);
            double spaceTaken = countSpaceTaken(file);
            int numberOfFolders = countFolders(file);
            System.out.println("Space taken = " + spaceTaken +
                    ". Number of files = " + numberOfFiles +
                    ". Number of folders = " + numberOfFolders);
        } else {
            System.out.println("Space taken = " + file.length() + ". Number of files = 1.");
        }
    }

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

    public static double countSpaceTaken(File file) {
        File[] files = file.listFiles();
        double countSpace = 0d;
        for (File f : files) {
            if (f.isDirectory())
                countSpace += countSpaceTaken(f);
            else
                countSpace += f.length();
        }
        return countSpace;
    }

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