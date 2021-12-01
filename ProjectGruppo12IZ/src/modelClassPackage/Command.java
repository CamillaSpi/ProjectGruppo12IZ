/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

/**
 *Command interface with method execute and undo that will be implemented by the class that implement this interface.
 * @author Gruppo 12 IZ
 */
public interface Command {
    void execute();
    void undo(); 
}
