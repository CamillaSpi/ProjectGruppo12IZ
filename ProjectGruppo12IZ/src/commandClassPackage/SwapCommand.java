/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import modelClassPackage.MyOperandCollection;

/**
 *
 * @author Gruppo12
 */
public class SwapCommand implements Command{

    private MyOperandCollection collector;

    /**
     * This method create an object that rappresent swap operation in order to execute and undo the command,
     * assert if collection is null or if not have enough operand
     * <p> <!-- -->
     * @param collector is the collection were call swap method
     * @see MyOperandCollection
     */
    public SwapCommand(MyOperandCollection collector) {
        assert collector != null;
        this.collector = collector;
        assert this.collector.collectionLength()>1;
    }
    
    /**
     * This method implements execute method for swap operation from Command interface
     */
    @Override
    public void execute() {
        collector.swap();
    }

    /**
     * This method implements undo method for swap operation from Command interface
     */
    @Override
    public void undo() {
        collector.swap();
    }
    
}
