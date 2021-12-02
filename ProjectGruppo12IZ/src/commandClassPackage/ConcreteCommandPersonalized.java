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
   
    /**
     * It creates an object of the ConcreteCommandPersonalized if the collector is not null and 
     * contains enough element to perform the division operation.
     * @param commandName is the name of the command, we choose to save this in this class, could be util for the future.
     * @param commands is the list of commands that compose this concrete complex command .
     * @see ComplexNumber, MyOperandCollection
     */
    public ConcreteCommandPersonalized(String commandName, List<Command> commands) {
        assert commands != null;
        this.commands = commands;
        this.commandName = commandName;
    }

    /**
     * It executes the complex operation throw the list of its basic operation list,
     * if it not performed at all, its undos all basic operation done at that moment.
     * @return a boolean value that rappresent if the execute operation is performed, false otherwise.
     * @see ComplexNumber, MyOperandCollection
     */
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
                    tmp = commands.get(count-i-1);
                    tmp.undo();
                }
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * It executes the undo of the complex operation throw the undos of its basic operation list.
     * @see ComplexNumber, MyOperandCollection
     */
    @Override
    public void undo() {
        int length = commands.size();
        for(int i = length-1; i >= 0; i--)
            commands.get(i).undo();
    }

    /**
     * It search in the list of basic operation if there is which is passed as parameter.
     * @param name is the name of the command to search in the complex command.
     * @return boolean, true if this method find the command, false otherwise.
     * @see ComplexNumber, MyOperandCollection
     */
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
