package learn.aditya.java.Feeder;

import learn.aditya.java.Engine.Engine;

import java.io.*;

public class FileFeeder {

    private String fileName = null;

    // What is the best way to read and write files
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    FileWriter fileWriter = null;
    BufferedWriter bufferedWriter = null;

    // We will write into a different file so that
    // original content is not damaged

    File fileToBeRead = null,fileToBeWritten = null;


    public FileFeeder(String fileName)
    {
        this.fileName = fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public BufferedReader getBufferedReader()
    {
        return bufferedReader;
    }

    public BufferedWriter getBufferedWriter()
    {
        return bufferedWriter;
    }

    public void loadFile()
    {
        //Incase the constructor with fileName is not used
        if(this.fileName == null)
        {
            System.out.println("Call either Feeder with constructor or use Feeder.setFileName()");
            return;
        }
        fileToBeRead = new File(this.fileName+".java");
        fileToBeWritten = new File(this.fileName.replace("source","debug")+".java");
        try {
            fileReader = new FileReader(fileToBeRead);
            bufferedReader = new BufferedReader(fileReader);
            fileWriter = new FileWriter(fileToBeWritten);
            bufferedWriter = new BufferedWriter(fileWriter);
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private void closeReadingFile()
    {
        try {
            bufferedReader.close();
            fileReader.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void closeWritingFile()
    {
        try{
            bufferedWriter.close();
            fileWriter.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }


}
