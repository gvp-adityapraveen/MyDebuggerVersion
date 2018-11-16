package learn.aditya.java.CategorizeBraces;

import java.util.Stack;

public class Brace {

    private static Brace braceInstance = null;

    private Stack<Character> braceStack = new Stack<Character>();

    private Brace()
    {
    }

    public void insertIntoStack(Character item)
    {
        this.braceStack.push(item);
    }

    public void removeFromStack()
    {
        this.braceStack.pop();
    }

    public static synchronized Brace getBraceInstance()
    {
        if(braceInstance == null)
        {
            braceInstance = new Brace();
        }
        return braceInstance;
    }
}
