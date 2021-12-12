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
 * @author Gruppo 12 IZ
 */
public class SaveVariablesCommand implements Command{

    private final Variables vars;

    /**
     * <p>
     * This method creates an object that represents saveVariablesIntoStack operation in order to execute and undo the command.
     * </p> <!-- -->
     * @param vars is the collection of the variables were call Save Variables operation.
     * @see Variables
     */
    public SaveVariablesCommand(Variables vars) {
        assert vars != null;
        this.vars = vars;
    }
    
    /**
     * <p>
     * This method implements execute method for saveVariablesIntoStack operation from Command interface.
     * </p> <!-- -->
     * @return true or false if operation executed.
     * @see Variables
     */
    @Override
    public boolean execute() {       
        return vars.saveVariablesIntoStack();
    }

    /**
     * <p>
     * This method implements undo method for saveVariablesIntoStack operation from Command interface.
     * </p> <!-- -->
     * @see Variables
     */
    @Override
    public void undo() {
        vars.restoreVariablesFromStack();
    }

}
