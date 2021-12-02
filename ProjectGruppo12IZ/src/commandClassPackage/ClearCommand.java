/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;

/**
 *
 * @author Gruppo 12 IZ
 */
public class ClearCommand implements Command{
    private MyOperandCollection collector;
    private List<ComplexNumber> backup;
    
    /**
     * This method creates an object that represents clear operation in order to execute and undo the command,
     * assert if collection is null or if it is empty.
     * <p> <!-- -->
     * @param collector is the collection were call clear method
     * @see MyOperandCollection
     */
    public ClearCommand(MyOperandCollection collector) {
        assert collector != null;
        this.collector = collector;
        this.backup = new LinkedList(this.collector.getL());
        assert this.collector.collectionLength()>0;
    }
    
    /**
     * This method implements execute method for clear operation from Command interface
     */
    @Override
    public void execute() {
        collector.clear();
    }

    /**
     * This method implements undo method for clear operation from Command interface
     */
    @Override
    public void undo() {
        for(int i = backup.size() - 1; i >= 0; i--){
            collector.insert(backup.get(i));
        }
    }
    
}
