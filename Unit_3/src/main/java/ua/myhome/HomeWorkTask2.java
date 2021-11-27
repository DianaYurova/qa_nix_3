package ua.myhome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HomeWorkTask2 {

    public void start() {
        System.out.println("Task2");
    }

    public void run() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your word");
            String value = scanner.nextLine();
            String key = "";
            char[] chars = value.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                key += String.valueOf((int) chars[i]);
            }
//        System.out.println(key);

            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(key, value);

            System.out.println("To enter another word please press 1");
            System.out.println("To see all values please press 9");
            System.out.println("To exit the program please press 0");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String cases;
            try {
                while ((cases = bufferedReader.readLine()) != null) {
                    switch (cases) {
                        case "1": {
                            run();
                        }
                        case "9": {

                            Set st = hashMap.entrySet();
                            Iterator it = st.iterator();
                            Map.Entry entry = (Map.Entry) it.next();
                            System.out.println(entry.getKey() + ":" + entry.getValue());
 /*                           for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                                String key1 = entry.getKey();
                                String value1 = entry.getValue();
                                System.out.println(key1 + ":" + value1);
                            }*/
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
    }

