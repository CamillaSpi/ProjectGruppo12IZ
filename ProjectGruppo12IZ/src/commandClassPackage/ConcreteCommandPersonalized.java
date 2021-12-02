/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import java.util.List;

/**
 *
 * @author Mattia
 */
public class ConcreteCommandPersonalized implements Command{
 
    private final String commandName;
    private final List<Command> commands;
   
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

    public boolean contains(String name) {
        for (Command myCommand : commands) {
            if (myCommand instanceof ConcreteCommandPersonalized) {
                if (name.equals(((ConcreteCommandPersonalized) myCommand).commandName)) {
                    return true;
                }
            }
        }
        return false;
    }

}
