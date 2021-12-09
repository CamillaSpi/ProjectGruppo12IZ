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
    
    public CommandRetrievingService(File file, HashCommandTable commands){
        this.file = file;
        this.commands = commands;
    }
    
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
