package learn.aditya.java.GraphLibrary;

public class Node {

    private String className;
    private String method;
    private int lineNumber;
    private Node nextNode = null;

    public Node(String className,String method,int lineNumber)
    {
        this.className = className;
        this.method = method;
        this.lineNumber = lineNumber;
    }

    public void setNextNode(Node n)
    {
        this.nextNode = n;
    }

    public Node getNextNode()
    {
        return this.nextNode;
    }

}
