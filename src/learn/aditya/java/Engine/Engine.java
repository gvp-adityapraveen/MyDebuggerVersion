package learn.aditya.java.Engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Engine {

    private static int lineNumber = 0;
    private static int totalNumberOfLinesProcessed = 0;
    private static String className = "";
    private static String methodName = "";

    public static void readLinebyLine(BufferedReader reader,BufferedWriter writer)
    {
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineNumber++;

                /*
                --------------MAIN LOGIC HERE ----------
                 */
                if(line.contains("class"))
                {
                    int index = line.indexOf("class");
                    int finalIndex = 0;
                    if(line.contains("{"))
                    {
                        finalIndex = line.indexOf("{");
                        className = line.substring(index+6,finalIndex);
                    }
                }
                else if(line.contains("{"))
                {
                    String lineContainingMethod = line.substring(0,line.indexOf("("));
                    int indexOfSpace = lineContainingMethod.lastIndexOf(" ");
                    methodName = lineContainingMethod.substring(indexOfSpace);
                }
                else if (line.contains("}"))
                {
                    writeTheBreak(writer,className,methodName,lineNumber);
                }
                writer.write(line+"\r\n");
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    private static void writeTheBreak(BufferedWriter writer,String className,String method,int lineNumber) {
        try {
            writer.write("System.out.println(\""+className + ":" + method + ":" + String.valueOf(lineNumber)+"\")" + "\r\n");
        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }

}
