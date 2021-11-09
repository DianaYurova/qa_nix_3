package ua.myhome;

import java.util.Scanner;

public class HomeWorkTask1 {

    public void run() {
        System.out.println("Task1");
        System.out.println("Please enter your text");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String[] inputText = text.split(" ");
        System.out.println("Please enter key word");
        Scanner inputKey = new Scanner(System.in);
        String key = inputKey.nextLine();
        for (String wordBeginning : inputText) {
            if (wordBeginning.startsWith(key)) {
                System.out.println("Word which start with " + key + ": " + wordBeginning);
            }
        }

        System.out.println("Please enter another key word");
        Scanner inputKey2 = new Scanner(System.in);
        String key2 = inputKey2.nextLine();
        for (String wordEnds : inputText) {
            if (wordEnds.endsWith(key2)) {
                System.out.println("Word which ends with " + key2 + ": " + wordEnds);
            }
        }
    }
}
