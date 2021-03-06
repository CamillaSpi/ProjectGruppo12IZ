/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import java.util.LinkedList;
import java.util.List;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;

/**
 *
 * @author Gruppo 12 IZ
 */
public class ClearCommand implements Command{
    private final MyOperandCollection collector;
    private MyOperandCollection backup;
    
    /**
     * <p>
     * This method creates an object that represents clear operation in order to
     * execute and undo the command, assert if collection is null or if it is empty.
     * </p> <!-- -->
     * @param collector is the collection were call clear method
     * @see ComplexNumber 
     * @see MyOperandCollection
     */
    public ClearCommand(MyOperandCollection collector) {
        assert collector != null;
        this.collector = collector;
    }
    
    /**
     * <p>
     * This method implements execute method for clear operation from Command interface
     * if it can be performed.
     * </p> <!-- -->
     * @return true if the collection is not empty and the operation is performed, false otherwise
     * @see MyOperandCollection
     */
    @Override
    public boolean execute() {
        this.backup = new MyOperandCollection(12);
        this.backup.addAllCollector(collector);
        if(this.collector.collectionLength() == 0)
            return false;
        collector.clear();
        return true;
    }

    /**
     * <p>
     * This method implements undo method for clear operation from Command interface
     * </p> <!-- -->
     * @see MyOperandCollection
     */
    @Override
    public void undo() {
        collector.addAllCollector(backup);
    }
    
}
