package learn.aditya.java;

public class TestDebugger {

    public TestDebugger() {
System.out.println("Test:Test:5");
        System.out.println("Inside Test Constructor");
    }

    private void get() {
System.out.println("Test:get:9");
        System.out.println("Inside private get Method");
    }

    public static void main(String args[]) {
System.out.println("Test:main:13");
        TestDebugger test = new TestDebugger();
        test.get();
        System.out.println("Inside Test Main Class");
    }
}
