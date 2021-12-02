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

    public Invoker() {
        stack = new ArrayDeque<>();
    }

    public void execute(Command command) {
        stack.addLast(command);
        command.execute();
    }

    public void undoLast() {
        Command last = stack.removeLast();
        last.undo();
    }
    
}
