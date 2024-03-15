package Practise;

import java.util.Scanner;

public class PractisePatternPyramid {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input number of rows :");
        int rows = scanner.nextInt();
        System.out.println();
        printRows(rows);
        scanner.close();
    }


    private static void printRows(int rows){
        System.out.println();
        for (int i=1 ; i <= rows ; i++){
            for (int j=0; j< rows-i; j++){
                System.out.print(" ");
            }
            printLine(i, rows);
        }
    }

    private static void printLine(int line, int rows){
        for(int i=0;i<line;i++){
            System.out.print(line%10+ " ");
        }
        System.out.println();
    }
}
