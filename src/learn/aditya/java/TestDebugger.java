package learn.aditya.java;

public class TestDebugger {

    public TestDebugger() {
        System.out.println("Inside Test Constructor");
System.out.println("Test : Test:7");
    }

    private void get() {
        System.out.println("Inside private get Method");
System.out.println("Test : get:11");
    }

    public static void main(String args[]) {
        TestDebugger test = new TestDebugger();
        test.get();
        System.out.println("Inside Test Main Class");
System.out.println("Test : main:17");
    }
//System.out.println("Test : main:18");
}
