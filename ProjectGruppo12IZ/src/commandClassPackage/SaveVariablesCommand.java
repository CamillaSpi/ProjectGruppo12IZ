/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commandClassPackage;

import modelClassPackage.MyOperandCollection;
import modelClassPackage.Variables;

/**
 *
 * @author nando
 * @time Dec 10, 2021 1:57:18 PM
 */
public class SaveVariablesCommand implements Command{

    private final Variables vars;

    /**
     * This method create an object that rappresent SaveToVariable operation in order to execute and undo the command.
     * <p> <!-- -->
     * @param vars is the name of the variable were call SaveToVariable.
     * @see MyOperandCollection
     */
    public SaveVariablesCommand(Variables vars) {
        assert vars != null;
        this.vars = vars;

    }
    
    /**
     * This method implements execute method for SaveToVariable operation from Command interface.
     * @return true or false if operation executed.
     */
    @Override
    public boolean execute() {       
        vars.saveVariablesIntoStack();
        return true;
    }

    /**
     * This method implements undo method for SaveToVariable operation from Command interface
     */
    @Override
    public void undo() {
        vars.restoreVariablesFromStack();
    }

}
