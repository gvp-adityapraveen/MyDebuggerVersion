package learn.aditya.java;

public class Test {

    public Test() {
        System.out.println("Inside Test Constructor");
    }

    private void get() {
        System.out.println("Inside private get Method");
    }

    public static void main(String args[]) {
        Test test = new Test();
        test.get();
        System.out.println("Inside Test Main Class");
    }
}
