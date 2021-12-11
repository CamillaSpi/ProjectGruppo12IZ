/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import modelClassPackage.Variables;

/**
 *
 * @author Gruppo 12 IZ
 */
public class RestoreVariablesCommand implements Command {

    private final Variables vars;

    /**
     * This method creates an object that represents restore variables from stack operation in
     * order to execute and undo the command, assert if the variables are null.
     * <p>
     * <!-- --> 
     * @param vars the object that contains the variables
     * @see Variables
     */
    public RestoreVariablesCommand(Variables vars) {
        assert vars != null;
        this.vars = vars;
    }

    /**
     * This method implements execute method for Restore variables command from
     * Command interface.
     * @return true if the operation of restoring is executed, false otherwise.
     * @see Variables
     */
    @Override
    public boolean execute() {
        return vars.restoreVariablesFromStack();
    }

    /**
     * This method implements undo method for Restore variables command operation from
     * Command interface; it does a save of the variables into the stack, calling the variables' method.
     * @see Variables
     */
    @Override
    public void undo() {
        vars.saveVariablesIntoStack();
    }

}
