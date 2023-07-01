//File Name StudentList.java
import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{

    public static void Reader()
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(constant.FileName)));
            studentName = bufferedReader.readLine();
            names = studentName.split(constant.split);
        }
        catch (Exception e) {}
    }

    public static void Writer(String updatedData)
    {
        try
        {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter("students.txt", false));
            //bufferedWriter.flush();
            bufferedWriter.write(updatedData);
            bufferedWriter.close();

        }
        catch (Exception e) {}
    }

    public static Constant constant = new Constant();
    public static String studentName;
    public static String names[];

    public static void main(String[] args)
    {
//		Check arguments
        if (args[0].equals(constant.showNames))
        {
            System.out.println(constant.loadingData);
            Reader();
            for (String name : names)
            {
                System.out.println(name);
            }

            System.out.println(constant.loadedData);
        }
        else if (args[0].equals(constant.randomName))
        {
            System.out.println(constant.loadingData);
            Reader();
            System.out.println(names[new Random().nextInt(names.length)]);

            System.out.println(constant.loadedData);
        }
        else if (args[0].contains(constant.addName))
        {
            System.out.println(constant.loadingData);
            Reader();

            Writer(studentName + constant.split + args[0].substring(1) + "\nList last updated on " + new SimpleDateFormat(constant.dateFormate).format(new Date()));

            System.out.println(constant.loadedData);
        }
        else if (args[0].contains(constant.query))
        {
            System.out.println(constant.loadingData);
            Reader();


            for (int idx = 0; idx < names.length; idx++)
            {
                if (names[idx].equals(args[0].substring(1)))
                {
                    System.out.println(constant.Found);
                    break;
                }
            }

            System.out.println(constant.loadedData);
        }
        else if (args[0].contains(constant.countWords))
        {
            System.out.println(constant.loadingData);
            Reader();

            System.out.println(names.length + constant.wordsFound);

            System.out.println(constant.loadedData);
        }
        else
        {
            System.out.println(constant.Invalid);
        }
    }
}
