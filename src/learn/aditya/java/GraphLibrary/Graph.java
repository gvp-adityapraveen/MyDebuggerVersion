package learn.aditya.java.GraphLibrary;

public class Graph {

    private static Graph graphInstance = null;

    private Graph(){}

    public static synchronized Graph getInstance()
    {
        if(graphInstance == null)
        {
            graphInstance =  new Graph();
        }
        return graphInstance;
    }

    public void createNode()
    {

    }

}
