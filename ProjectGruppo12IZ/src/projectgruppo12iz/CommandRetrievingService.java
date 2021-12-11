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
public class CommandRetrievingService extends Service<HashCommandTable>{

    private final File file;
    private final HashCommandTable commands;
    
    /**
     * it create an object of this service that can call a task to restore user 
     * operations from an adeguate file passed.
     * @param file is the file where take saved user operations.
     * @param commands is the object of the HashCommandTable where save the 
     * restored user operations.
     */
    public CommandRetrievingService(File file, HashCommandTable commands){
        this.file = file;
        this.commands = commands;
    }
    
    /**
     * it call a task function to restore the user operations from an adeguate 
     * saved as attribute. It override Task method that return the structure 
     * updated or null if it isn't possible for any motiv.
     */
    @Override
    protected Task<HashCommandTable> createTask() {
        
        return new Task<HashCommandTable>() {
            @Override
            protected HashCommandTable call() throws Exception {

                if(commands.readCommandFromFile(file))
                    return commands;
                else
                    return null;
            }
        };

    }
    
}
