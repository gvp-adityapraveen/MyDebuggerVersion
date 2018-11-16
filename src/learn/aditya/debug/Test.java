package learn.aditya.debug;

public class Test {

        public Test() {
System.out.println("Test:Test:5");

        }
    
        private void get() {
System.out.println("Test:get:9");

        }
    
        public static void main(String args[]) {
System.out.println("Test:main:13");
            Test test = new Test();
            test.get();
            for(int i=0;i<3;i++)
System.out.println("Test:for:16");
            {
                test.get();
            }
        }
    }

