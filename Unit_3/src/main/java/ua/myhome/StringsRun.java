package ua.myhome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringsRun {

    public static void run() {

        System.out.println("Here program will be");

        preview();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String event;
        try {
            while ((event = reader.readLine()) != null) {
                switch (event) {
                    case "1": {
                        new HomeWorkTask1().run();
                    }
                    break;
                    case "2": {
                        new HomeWorkTask2().run();
                    }
                    break;
                    case "0": {
                        System.exit(0);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void preview() {

        System.out.println("Please enter 1 to launch first task");
        System.out.println("Please enter 2 to launch second task");
        System.out.println("Please enter 0 to exit task");
        System.out.println("Please make your choice");
        System.out.println();
    }
}

