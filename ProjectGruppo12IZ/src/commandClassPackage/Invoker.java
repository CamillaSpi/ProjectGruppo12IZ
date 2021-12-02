/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commandClassPackage;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Gruppo 12 IZ
 */
public class Invoker{
    private Deque<Command> stack;
    
    /**
     * It creates an object of the class Invoker.
     */
    public Invoker() {
        stack = new ArrayDeque<>();
    }
    
    /**
     * execute method of class Invoker that adds the command to be executed, passed as a parameter, 
     * into the invoker's deque and launches the execute method of the command.
     * @see Command
     */
    public void execute(Command command) {
        stack.addLast(command);
        command.execute();
    }
    
    /**
     * undo method of class Invoker that undo the last command launched removing it from 
     * the invoker's deque and launches the undo method of the last command.
     * @see Command
     */
    public void undoLast() {
        Command last = stack.removeLast();
        last.undo();
    }
    
}
