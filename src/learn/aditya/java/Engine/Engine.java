package learn.aditya.java.Engine;

import learn.aditya.java.CategorizeBraces.Brace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Engine {

    private static int lineNumber = 0;
    private static int totalNumberOfLinesProcessed = 0;
    private static String className = "";
    private static String methodName = "";
    private static Brace braceInstance = Brace.getBraceInstance();

    private static ArrayList<String> keywordsNotAcceptedInMethods = new ArrayList<String>(Arrays.asList
            ("if", "else","for","do","while","switch","="));

    public static void readLineByLine(BufferedReader reader, BufferedWriter writer)
    {
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineNumber++;
                totalNumberOfLinesProcessed++;
                if(line.contains("package"))
                {
                    line = line.replace("source","debug");
                }

                writer.write(line+"\r\n");

                if(line.equals(""))
                    continue;


                /*
                --------------MAIN LOGIC HERE ----------
                 */
                if (line.contains("class")) {
                    findClass(line);
                } else if (!line.contains(".")&&line.contains("(") && line.contains(")") && line.split(" ").length >= 2 && dontContainKeywords(line))
                {
                    findMethod(line);
                    writeTheBreak(writer,className,methodName,lineNumber);
                }
                else
                {
                    if(line.contains("{"))
                    {
                        braceInstance.insertIntoStack('{');
                    }
                    if(line.contains("}"))
                    {
                        braceInstance.removeFromStack();
                    }
                }

            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    private static boolean dontContainKeywords(String line)
    {
        String [] words = line.split(" ");
        for(int i=0;i<words.length;i++)
        {
            if(keywordsNotAcceptedInMethods.contains(words[i]))
                return false;
        }
        return true;
    }

    private static void findClass(String line)
    {
        if(line.contains("{"))
        {
            braceInstance.insertIntoStack('{');
        }
        if(line.contains("}"))
        {
            braceInstance.removeFromStack();
        }
        int indexOfOpeningBrace = line.indexOf("{");
        String line2 = line;
        if(indexOfOpeningBrace != -1)
        {
            line2 = line2.substring(0,indexOfOpeningBrace);
        }
        String[] words = line2.split(" ");
        className = words[words.length-1];
    }

    private static void findMethod(String line)
    {
        if(line.contains("{"))
        {
            braceInstance.insertIntoStack('{');
        }
        if(line.contains("}"))
        {
            braceInstance.removeFromStack();
        }
        int indexOfOpenParenthesis = line.indexOf('(');
        String line1 = line.substring(0,indexOfOpenParenthesis);
        String [] line2 = line1.split(" ");
        methodName = line2[line2.length-1];
    }

    private static void writeTheBreak(BufferedWriter writer,String className,String method,int lineNumber) {
        try {
            writer.write("System.out.println(\""+className + ":" + method + ":" + String.valueOf(lineNumber)+"\");" + "\r\n");
        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }

}
