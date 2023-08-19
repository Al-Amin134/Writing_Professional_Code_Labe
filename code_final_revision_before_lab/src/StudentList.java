//File Name StudentList.java
import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {



    public static  Constant constant = new Constant();
    public static String names[];
    public static String studentName;
    public static void Reader() {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(constant.FILENAME)));
            studentName = bufferedReader.readLine();
            names = studentName.split(constant.SPLIT);//এই লাইন টাতে ভুল হয়েছিল এখান থেকে string names[] দিয়ে আবার initiate করছিলাম।
        } catch (Exception e) {
        }
    }

public static String Writer(String updated_text) {
    try {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(constant.FILENAME, false));
        bufferedWriter.write(updated_text);
        bufferedWriter.close();


    } catch (Exception e) {}
    return updated_text;
}

    public static void main(String[] args) {
//		Check arguments

        if (args.length != 1) {
            System.out.println(constant.INVALIED);
            return;
        }


        if (args[0].equals(constant.SHOW_DATA)) {
            System.out.println(constant.LOADING);
            Reader();
            for (String j : names) {
                System.out.println(j);
            }
            System.out.println(constant.LOADED);
    }
        else if(args[0].equals(constant.RANDOM)) {
            System.out.println(constant.LOADING);
            Reader();
            System.out.println(names[new Random().nextInt(names.length)]);//বাউন্ড must দিতে হবে
            System.out.println(constant.LOADED);
        }
        else if(args[0].contains(constant.ADD_DATA))
        {
            System.out.println(constant.LOADING);
                Reader();
                Writer(studentName+args[0].substring(1)+constant.LIST_LAST_UPDATED_ON+new SimpleDateFormat(constant.DATE_FORMATE).format(new Date()));
            System.out.println(constant.LOADED);
        }


        else if(args[0].contains(constant.QUERY))
        {
            System.out.println(constant.LOADING);
               Reader();
                String t = args[0].substring(1);
                for(int i = 0; i<names.length; i++)
                {
                    if(names[i].equals(t))
                    {
                        System.out.println(constant.FOUND);
                       break;
                    }

                    if(i== names.length-1){
                        System.out.println(constant.NOT_FOUND);
                    }
                }
            System.out.println(constant.LOADED);
        }


        else if(args[0].contains(constant.COUNT))
        {
            System.out.println(constant.LOADING);
           Reader();
        int i = names.length;
                System.out.println(i +constant.WORDS_FOUND);
            System.out.println(constant.LOADED);
        }
    }
}
