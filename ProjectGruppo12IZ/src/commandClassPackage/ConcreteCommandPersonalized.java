/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import java.util.List;
import modelClassPackage.MyOperandCollection;

/**
 *
 * @author Mattia
 */
public class ConcreteCommandPersonalized implements Command{

    private List<Command> commands;
    private final String commandName;

    public ConcreteCommandPersonalized(String commandName, List<Command> commands) {
        assert commands != null;
        this.commands = commands;
        this.commandName = commandName;
    }
    
    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
