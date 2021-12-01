/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;

/**
 *
 * @author Gruppo12
 */
public class DropCommand implements Command{

    private final MyOperandCollection collector;
    private final ComplexNumber first;

    /**
     * This method create an object that rappresent drop operation in order to execute and undo the command,
     * assert if collection is null or if not have enough operand
     * <p> <!-- -->
     * @param collector is the collection were call drop method
     * @see MyOperandCollection
     */
    public DropCommand(MyOperandCollection collector) {
        assert collector != null;
        this.collector = collector;
        this.first = collector.last();
        assert this.first != null;
    }
    
    /**
     * This method implements execute method for drop operation from Command interface
     */
    @Override
    public void execute() {
        collector.drop();
    }

    /**
     * This method implements undo method for drop operation from Command interface
     */
    @Override
    public void undo() {
        collector.insert(first);
    }
    
}
