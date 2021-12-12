/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgruppo12iz;

import commandClassPackage.HashCommandTable;
import java.io.File;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 *
 * @author Gruppo 12 IZ
 */
public class SaveService extends Service<HashCommandTable>{
    
    private final File file;
    private final HashCommandTable userCommand;

    /**
     * <p>
     * it create an object of this service that can call a task to save user 
     * operations to a file passed as param in this constructor.
     * </p> <!-- -->
     * @param file is the file where save user operations.
     * @param commands is the object of the HashCommandTable from take saved user operations.
     */
    public SaveService(File file, HashCommandTable userCommand) {
        this.file = file;
        this.userCommand = userCommand;
    }

    /**
     * <p>
     * it call a task function to save user operations to a file saved as attribute.
     * It override Task method that return the structure if the save is complete,
     * or null if it isn't possible for any motiv.
     * </p> <!-- -->
     */
    @Override
    protected Task<HashCommandTable> createTask() {

        return new Task<HashCommandTable>() {
            @Override
            protected HashCommandTable call() throws Exception {
                if(userCommand.printCommandToFile(file))
                    return userCommand;
                else
                    return null;
            }
        };
    }
}
