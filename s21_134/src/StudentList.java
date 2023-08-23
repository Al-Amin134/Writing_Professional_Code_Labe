import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{
    public static String names[];
    public static String studentName;
    public static Constant constant = new Constant();
    public static void Reader()
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(constant.FILE_NAME)));
            studentName = bufferedReader.readLine();
            names = studentName.split(constant.SPLIT);
        }
        catch (Exception e)
        {
        }
    }

    public static void Writer(String updatedText)
    {
        try
        {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(constant.FILE_NAME, true));//here true means it will be available after write a string here...
            bufferedWriter.write(updatedText);
            bufferedWriter.close();
        }
        catch (Exception e)
        {
        }
    }


    public static void main(String[] args)
    {

//		Check arguments
//if argument is not with 1 word
        if(args.length!=1)
        {
            System.out.println(constant.INVALID);
            return;
        }
        //insert a to show data
        if(args[0].equals(constant.SHOW_DATA))
        {
            System.out.println(constant.LOADING);
            Reader();
            for(String j : names)
            {
                System.out.println(j);
            }

            System.out.println(constant.LOADED);
        }
        //argument is r for random word
        else if(args[0].equals(constant.RANDOM))
        {
            System.out.println(constant.LOADING);
            Reader();

            System.out.println(names[new Random().nextInt(names.length)]);
            System.out.println(constant.LOADED);
        }

//adding data(date and time)
        else if(args[0].contains(constant.ADD_DATA))
        {
            System.out.println(constant.LOADING);
            Reader();
            Writer(constant.SPLIT+args[0].substring(1)+constant.ListLastUpdated+new SimpleDateFormat(constant.DATE_FORMATE).format(new Date()));
            System.out.println(constant.LOADED);
        }

//search word
        else if(args[0].contains(constant.QUERY))
        {
            System.out.println(constant.LOADING);
            Reader();
            names = studentName.split(constant.SPLIT);
            String t = args[0].substring(1);
            for(int idx = 0; idx<names.length; idx++)
            {
                if(names[idx].equals(t))
                {
                    System.out.println(constant.FOUND);
                    break;
                }
            }

            System.out.println(constant.LOADED);
        }

        //words count
        else if(args[0].contains(constant.COUNT))
        {
            System.out.println(constant.LOADING);
            Reader();
            System.out.println(names.length +constant.WORDS_FOUND);

            System.out.println(constant.LOADED);
        }

        else
        {
            System.out.println(constant.INVALID);
        }
    }
}
