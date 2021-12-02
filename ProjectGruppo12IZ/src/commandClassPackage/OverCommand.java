/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import modelClassPackage.MyOperandCollection;

/**
 *
 * @author Mattia
 */
public class OverCommand implements Command{

    private final MyOperandCollection collector;

    /**
     * This method create an object that rappresent OverCommand operation in order to execute and undo the command,
     * assert if collection is null or if not have enough operand
     * <p> <!-- -->
     * @param collector is the collection were call swap method
     * @see MyOperandCollection
     */
    public OverCommand(MyOperandCollection collector) {
        assert collector != null;
        this.collector = collector;
        
    }
    
    /**
     * This method implements execute method for over operation from Command interface
     */
    @Override
    public boolean execute() {
        if(this.collector.collectionLength()<=1)
            return false;
        collector.over();
        return true;
    }

    /**
     * This method implements undo method for over operation from Command interface
     */
    @Override
    public void undo() {
        collector.remove();
    }
    
}
