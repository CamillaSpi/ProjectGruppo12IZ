/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import modelClassPackage.MyOperandCollection;

/**
 *
 * @author Gruppo 12 IZ
 */
public class SwapCommand implements Command{

    private final MyOperandCollection collector;

    /**
     * This method creates an object that represents swap operation in order to execute and undo the command,
     * assert if collection is null.
     * <p> <!-- -->
     * @param collector is the collection were call swap method
     * @see MyOperandCollection
     */
    public SwapCommand(MyOperandCollection collector) {
        assert collector != null;
        this.collector = collector;
    }
    
    /**
     * This method implements execute method for swap operation from Command interface.
     * @return false if the collection doesn't contain at least 2 elements, true otherwise.
     * @see MyOperandCollection
     */
    @Override
    public boolean execute() {
        if(this.collector.collectionLength()<=1)
            return false;
        collector.swap();
        return true;
    }

    /**
     * This method implements undo method for swap operation from Command interface, doing another 
     * swap to restore the old order of operands. 
     * @see MyOperandCollection
     */
    @Override
    public void undo() {
        collector.swap();
    }
    
}
