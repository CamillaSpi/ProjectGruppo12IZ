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
 
    private final String commandName;
    private List<Command> commands;
   
    public ConcreteCommandPersonalized(String commandName, List<Command> commands) {
        assert commands != null;
        this.commands = commands;
        this.commandName = commandName;
    }
    
    @Override
    public boolean execute() {
        int count=0;
        boolean flag = true;
        for (Command command : commands){
            if(command.execute()){
                count++;
            }
            else{
                Command tmp;
                for (int i=0; i<count; i++){
                    tmp = commands.get(count-i);
                    tmp.undo();
                }
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public void undo() {
        for (Command command : commands){
            command.undo();
        }
    }
    
}
