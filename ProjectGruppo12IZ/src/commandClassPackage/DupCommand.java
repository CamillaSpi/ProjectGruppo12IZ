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
 * @author Gruppo 12 IZ
 */
public class DupCommand implements Command{

    private final MyOperandCollection collector;
    private ComplexNumber first;

    /**
     * This method create an object that rappresent Dup operation in order to
     * execute and undo the command, assert if collection is null or if not 
     * have enough operand.
     * <p> <!-- -->
     * @param collector is the collection were call drop method
     * @see MyOperandCollection
     */
    public DupCommand(MyOperandCollection collector) {
        assert collector != null;
        this.collector = collector;
        
    }
    
    /**
     * This method implements execute method for Dup Command operation from
     * Command interface if it is possible to perform.
     * @return true it is execute, false otherwise.
     */
    @Override
    public boolean execute() {
        this.first = collector.last();
        if(this.first == null)
            return false;
        collector.dup();
        return true;
    }

    /**
     * This method implements undo method for Dup Command operation from Command interface
     */
    @Override
    public void undo() {
        collector.remove();
    }
    
}
