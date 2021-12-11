/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commandClassPackage;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Gruppo 12 IZ
 */
public class Invoker{
    private final Deque<Command> stack;
    
    /**
     * It creates an object of the class Invoker.
     */
    public Invoker() {
        stack = new ArrayDeque<>();
    }
    
    /**
     * Execute method of class Invoker that adds the command to be executed, passed as a parameter, 
     * into the invoker's deque and launches the execute method of the command.
     * @param command command that has to be executed.
     * @return true, if the op has been executed, false otherwise.
     * @see Command
     */
    public boolean execute(Command command) {
        stack.addLast(command);
        return command.execute();
    }
    
    /**
     * Undo method of class Invoker that does the undo of the last command launched removing it from 
     * the invoker's deque and launching the command's undo method.
     * @see Command
     */
    public void undoLast() {
        Command last = stack.removeLast();
        last.undo();
    }

    /**
     * Getter method of the command's stack of the Invoker.
     * @return Deque of commands attribute of the invoker.
     * @see Command
     */
    public Deque<Command> getStack() {
        return stack;
    }
    
}
