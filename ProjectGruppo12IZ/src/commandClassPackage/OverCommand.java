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
public class OverCommand implements Command{

    private final MyOperandCollection collector;

    /**
     * This method creates an object that represent OverCommand operation in order to execute and undo the command,
     * assert if collection is null.
     * <p> <!-- -->
     * @param collector is the collection were call over command
     * @see MyOperandCollection
     */
    public OverCommand(MyOperandCollection collector) {
        assert collector != null;
        this.collector = collector;
    }
    
    /**
     * This method implements execute method for over operation from Command interface, calling method over of the collection.
     * @return false if the collection doesn't have at least 2 elements, true otherwise.
     * @see MyOperandCollection
     */
    @Override
    public boolean execute() {
        if(this.collector.collectionLength()<=1)
            return false;
        collector.over();
        return true;
    }

    /**
     * This method implements undo method for over operation from Command interface, removing the last inserted elements.
     * @see MyOperandCollection
     */
    @Override
    public void undo() {
        collector.remove();
    }
    
}
