/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gruppo 12 IZ
 */
public class ConcreteCommandPersonalized implements Command, Serializable {

    private final String commandName;
    private final String operations;
    private final List<Command> commands;

    /**
     * <p>
     * It creates an object of the ConcreteCommandPersonalized if the collector
     * is not null and
     * </p> <!-- -->
     *
     * @param commandName is the name of the command, we choose to save this in
     * this class, could be util for the future.
     * @param operations is the string that the user write to create the
     * specific concrete command
     * @param commands is the list of commands that compose this concrete
     * complex command.
     * @see Command
     */
    public ConcreteCommandPersonalized(String commandName, String operations, List<Command> commands) {
        assert commands != null;
        this.commands = new LinkedList<>();
        this.commands.addAll(commands);
        this.operations = operations;
        this.commandName = commandName;
    }

    /**
     * <p>
     * It creates an object of the ConcreteCommandPersonalized if the param is
     * not null from another concrete command
     * </p> <!-- -->
     *
     * @param commands is the command from which to create a copy
     * @see Command
     */
    public ConcreteCommandPersonalized(ConcreteCommandPersonalized commands) {
        assert commands != null;
        this.commands = new LinkedList<>();
        this.commands.addAll(commands.commands);
        this.operations = commands.operations;
        this.commandName = commands.commandName;
    }

    /**
     * <p>
     * getter method for Name of command.
     * </p> <!-- -->
     *
     * @return String rappresent the name of the operations
     * @see Command
     */
    public String getCommandName() {
        return commandName;
    }

    /**
     * <p>
     * getter method for operations contains in the command.
     * </p> <!-- -->
     *
     * @return String rappresent operations
     * @see Command
     */
    public String getCommands() {
        return operations;
    }

    /**
     * <p>
     * It search in the list of basic operation if there is which is passed as
     * parameter.
     * </p> <!-- -->
     *
     * @param name is the name of the command to search in the complex command.
     * @return boolean true if this method find the command, false otherwise.
     * @see Command
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

    /**
     * <p>
     * it create a string explanatory of the concrete personalized command.
     * </p> <!-- -->
     *
     * @return the string create
     * @see Command
     */
    @Override
    public String toString() {
        return operations;
    }

    /**
     * <p>
     * It executes the complex operation throw the list of its basic operation
     * list, if it not performed at all, its undos all basic operation done at
     * that moment.
     * </p> <!-- -->
     *
     * @return a boolean value that represent if the execute operation is
     * performed, false otherwise.
     * @see Command
     */
    @Override
    public boolean execute() {
        int count = 0;
        boolean flag = true;
        for (Command command : commands) {
            if (command.execute()) {
                count++;
            } else {
                Command tmp;
                for (int i = 0; i < count; i++) {
                    tmp = commands.get(count - i - 1);
                    tmp.undo();
                }
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * <p>
     * It executes the undo of the complex operation throw the undos of its
     * basic operation list.
     * </p> <!-- -->
     *
     * @see Command
     */
    @Override
    public void undo() {
        int length = commands.size();
        for (int i = length - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}
