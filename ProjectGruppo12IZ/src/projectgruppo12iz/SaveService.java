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
 * @author Mattia
 */
public class SaveService extends Service<HashCommandTable>{
    
    private final File file;
    private final HashCommandTable userCommand;

    public SaveService(File file, HashCommandTable userCommand) {
        this.file = file;
        this.userCommand = userCommand;
    }

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
