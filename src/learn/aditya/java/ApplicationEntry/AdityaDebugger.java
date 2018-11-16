package learn.aditya.java.ApplicationEntry;

import learn.aditya.java.Engine.Engine;
import learn.aditya.java.Feeder.FileFeeder;

public class AdityaDebugger {

    private String fileLocationAndName ="D:\\MyVersionOfDebuggerWorkspace\\src\\learn\\aditya\\source\\Test";

    public static void main(String args[])
    {
        System.out.println("Welcome to Aditya's Debugger");
        AdityaDebugger debugger = new AdityaDebugger();
        FileFeeder feeder = new FileFeeder(debugger.fileLocationAndName);
        feeder.loadFile();
        Engine.readLineByLine(feeder.getBufferedReader(),feeder.getBufferedWriter());
        feeder.closeWritingFile();
    }
}
